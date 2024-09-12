class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] allowedSet = new boolean[26];

        for(char c : allowed.toCharArray()){
            allowedSet[c - 'a'] = true;
        }

        int count = 0;

        for(String word : words){
            boolean isConsistent = true;

            for(char w : word.toCharArray()){
                if(!allowedSet[w - 'a']){
                    isConsistent = false;
                    break;
                }
            }

            if(isConsistent){
                count++;
            }
        }

        return count;
    }
}