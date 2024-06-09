class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        // Mod Value, Index
        HashMap<Integer, Integer> modMap = new HashMap<Integer, Integer>();
        modMap.put(0, 1);

        int runningSum = 0;

        for(int i = 0; i < n; i++){
            runningSum += nums[i];
            int mod = (runningSum % k + k) % k;

            if (modMap.containsKey(mod)) {
                count += modMap.get(mod);
            }
            modMap.put(mod, modMap.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}