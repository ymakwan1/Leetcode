class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        int count = 0;
        int n = s.length();

        // Brute
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(hash, 0);
        //     for(int j = i; j < n; j++){
        //         hash[s.charAt(j) - 'a'] = 1;
        //         if(hash[0] + hash[1] + hash[2] == 3){
        //             count = count + (n-j);
        //             break;
        //         }
        //     }
        // }

        // Optimal
        Arrays.fill(hash, -1);
        for(int i = 0; i < n; i++){
            hash[s.charAt(i) - 'a'] = i;

            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                count = count + (1 + Math.min(hash[0], Math.min(hash[1], hash[2])));
            }
        }

        return count;
    }
}