class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        int[] charArrayString1 = new int[26];
        int[] charArrayString2 = new int[26];
        
        if (s1.length() > s2.length()){
            return false;
        }
        
        for(int i = 0; i < s1.length(); i++){
            charArrayString1[s1.charAt(i) - 'a']++;
        }
        
        for(int j = 0 ; j < s2.length() ; j++){
            charArrayString2[s2.charAt(j) - 'a']++;
            
            if(j >= s1.length()){
                charArrayString2[s2.charAt(j - s1.length()) - 'a']--;
            }
            
            if(Arrays.equals(charArrayString1, charArrayString2)){
                return true;
            }
        }
        return false;
    }
}