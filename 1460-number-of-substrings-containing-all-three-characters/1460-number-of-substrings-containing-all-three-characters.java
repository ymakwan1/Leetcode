class Solution {
    public int numberOfSubstrings(String s) {
        int[] hash = new int[3];
        Arrays.fill(hash, -1);
        int count = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            hash[s.charAt(i) - 'a'] = i;

            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1){
                count = count + (1 + Math.min(hash[0], Math.min(hash[1], hash[2])));
            }
        }

        return count;
    }
}