class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        //Brute
        // int minLen = Integer.MAX_VALUE;
        // int startIndex = -1, count = 0;
        // int[] hash;

        // for(int i = 0; i < s.length(); i++){
        //     hash = new int[256];
        //     count = 0;
        //     for(int j = 0; j < t.length(); j++){
        //         hash[t.charAt(j)]++;
        //     }
        //     for(int j = i; j < s.length(); j++){
        //         if(hash[s.charAt(j)] > 0){
        //             count += 1;
        //         }
        //         hash[s.charAt(j)]--;
        //         if(count == t.length()){
        //             if (j - i + 1 < minLen) {
        //                 minLen = j - i + 1;
        //                 startIndex = i;
        //             }
        //             break;
        //         }
        //     }
        // }

        // return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);

        //Optimal
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1, count = 0;
        int[] hash = new int[256];

        for(int i = 0; i < t.length(); i++){
            hash[t.charAt(i)]++;
        }

        while(r < s.length()){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;

            while(count == t.length()){
                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    startIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0){
                    count--;
                }
                l++;
            }
            r++;
        }
        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}