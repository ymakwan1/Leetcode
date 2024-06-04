class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        int length = 0;
        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }else{
                set.remove(c);
                length += 2;
            }
        }
        if(!set.isEmpty()){
            length += 1;
        }
        return length;
    }
}