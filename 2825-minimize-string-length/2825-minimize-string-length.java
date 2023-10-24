class Solution {
    public int minimizedStringLength(String s) {
        //StringBuilder result = new StringBuilder(s);
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
            }
        }
        return set.size();
    }
}