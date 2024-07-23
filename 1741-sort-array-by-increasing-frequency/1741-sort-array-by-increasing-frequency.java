class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());

        frequencyList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return a.getValue() - b.getValue();
            } else {
                return b.getKey() - a.getKey();
            }
        });

        List<Integer> sortedNums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyList) {
            int element = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; i++) {
                sortedNums.add(element);
            }
        }

        int[] result = new int[sortedNums.size()];
        for (int i = 0; i < sortedNums.size(); i++) {
            result[i] = sortedNums.get(i);
        }

        return result;
    }
}
