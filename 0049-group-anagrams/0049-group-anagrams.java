class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] count = new char[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            String key = new String(count);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(map.values());
    }
}