class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tiles.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return backtrack(map);
    }

    private int backtrack(Map<Character, Integer> map){
        int count = 0;
        for(char c : map.keySet()){
            if(map.get(c) > 0){
                map.put(c, map.get(c) - 1);
                count += 1 + backtrack(map);
                map.put(c, map.get(c) + 1);
            }
        }
        return count;
    }
}