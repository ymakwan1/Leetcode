class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        
        if (strs.length == 0) {
            return groupedAnagrams;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String anagramString = new String(charArray);
            
            if(!map.containsKey(anagramString)) {
                map.put(anagramString, new ArrayList<>());
            }
            
            map.get(anagramString).add(str);
        }
        
        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}