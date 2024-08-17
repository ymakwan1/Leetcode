class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;

        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);

        for(int i = 1; i < arrays.size(); i++){
            List<Integer> current = arrays.get(i);
            int currentMin = current.get(0);
            int currentMax = current.get(current.size() - 1);

            if (currentMax > minVal) {
                result = Math.max(result, currentMax - minVal);
            }
            if (maxVal > currentMin) {
                result = Math.max(result, maxVal - currentMin);
            }

            if (currentMin < minVal) {
                minVal = currentMin;
            }
            if (currentMax > maxVal) {
                maxVal = currentMax;
            }
        }

        return result;
    }
}