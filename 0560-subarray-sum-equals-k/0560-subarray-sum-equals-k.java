class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int previousSum = 0;
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>(); //previousSum, count

        map.put(0, 1);

        for (int i = 0; i < n; i++) {
            previousSum += nums[i];

            int remove = previousSum - k;
            if (map.containsKey(remove)) {
                count += map.get(remove);
            }

            map.put(previousSum, map.getOrDefault(previousSum, 0) + 1);

        }
        return count;
    }
}