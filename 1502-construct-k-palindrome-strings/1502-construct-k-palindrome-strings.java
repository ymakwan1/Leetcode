class Solution {
    public boolean canConstruct(String s, int k) {
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        for(int f : freq){
            if(f % 2 != 0){
                oddCount++;
            }
        }
        
        if(k <= s.length() && k >= oddCount){
            return true;
        }

        return false;
    }
}