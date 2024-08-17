class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;

        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);

        for(int i = 1; i < arrays.size(); i++){
            List<Integer> current = arrays.get(i);
            int currentMin = current.get(0);
            int currentMax = current.get(current.size() - 1);

            result = Math.max(result, Math.abs(currentMax - minVal));
            result = Math.max(result, Math.abs(maxVal - currentMin));

            minVal = Math.min(minVal, currentMin);
            maxVal = Math.max(maxVal, currentMax);
        }

        return result;
    }
}