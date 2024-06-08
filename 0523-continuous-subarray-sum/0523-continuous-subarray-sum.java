class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;

        if(n < 2){
            return false;
        }

        // Mod Value, Index
        HashMap<Integer, Integer> modMap = new HashMap<Integer, Integer>();
        modMap.put(0, -1);

        int runningSum = 0;

        for(int i = 0; i < n; i++){
            runningSum += nums[i];
            int mod = k == 0 ? runningSum : runningSum % k;

            if(modMap.containsKey(mod)) {
                if(i - modMap.get(mod) > 1){
                    return true;
                }
            }else{
                modMap.put(mod, i);
            }
        }

        return false;
    }
}