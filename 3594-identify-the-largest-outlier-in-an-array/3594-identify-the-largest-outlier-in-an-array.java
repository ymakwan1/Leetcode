class Solution {
    public int getLargestOutlier(int[] nums) {
        int totalSum = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for(int n : nums){
            totalSum += n;
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        int maxOutlier = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            int remainingSum = totalSum - num;

            if (remainingSum % 2 != 0) {
                continue;
            }

            int half = remainingSum / 2;
            int halfCount = freqMap.getOrDefault(half, 0);

            if (half == num && halfCount < 2) continue;
            if (halfCount > 0) {
                maxOutlier = Math.max(maxOutlier, num);
            }
        }

        return maxOutlier;
    }
}