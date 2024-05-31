class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i : nums) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> mapEntry : hashMap.entrySet()) {
            if (mapEntry.getValue() == 1) {
                list.add(mapEntry.getKey());
            }
        }
        
        // Converting ArrayList to int array
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}