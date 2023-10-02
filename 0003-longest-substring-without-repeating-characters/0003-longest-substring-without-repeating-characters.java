class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        
        Set<Character> set = new HashSet<>();
        
        char[] charArray = s.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
            while(set.contains(charArray[i])){
                set.remove(charArray[start]);
                start += 1;
            }
            set.add(charArray[i]);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}