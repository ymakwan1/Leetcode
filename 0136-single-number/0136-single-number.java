class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
         int elementWithCountOne = -1; // Default value if no element with count 1 is found
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();
            if (count == 1) {
                elementWithCountOne = element;
                break;
            }
        }
        return elementWithCountOne;
    }
}