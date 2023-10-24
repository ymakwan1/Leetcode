class Solution {
    public int minimizedStringLength(String s) {
        //StringBuilder result = new StringBuilder(s);
        //Set<Character> set = new HashSet<>();
        int[] charArray = new int[26];
        int count = 0;
        // for(char c : s.toCharArray()){
        //     if(!set.contains(c)){
        //         set.add(c);
        //     }
        // }
        for(int i = 0; i < s.length(); i++){
            if(charArray[s.charAt(i) - 'a'] != 1){
                charArray[s.charAt(i) - 'a']++;
                count++;
            }
        }
        return count;
    }
}