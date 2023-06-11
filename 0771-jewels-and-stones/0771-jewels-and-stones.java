class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> map= new HashMap<Character, Integer>();
        int count = 0;
        char[] jwls = jewels.toCharArray();
        for(char c : jwls){
            map.put(c, map.getOrDefault(c, 1)+1);
        }

        char[] st = stones.toCharArray();
        for(char s : st){
            if(map.containsKey(s)){
                count = count + 1;
            }
        }
        return count; 
    }
}