class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> mapEntry : hashMap.entrySet()){
            if (mapEntry.getValue() == 1) {
                return mapEntry.getKey();
            }
        }
        return 0;
    }
}