class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> orderedMap = new LinkedHashMap<>();
        String[] words = s.split("");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(words));
        
        for(char c : s.toCharArray()){
            if (orderedMap.containsKey(c)) {
                orderedMap.put(c, orderedMap.get(c) + 1);
            } else {
                orderedMap.put(c, 1);
            }
        }
         for (int i = 0; i < s.length(); i++) {
            if (orderedMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        
        return -1;
        
    }
}