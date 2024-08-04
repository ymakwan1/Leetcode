class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> subSums = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                subSums.add(sum);
            }
        }

        Collections.sort(subSums);

        for(int i = 0; i < subSums.size(); i++){
            System.out.print(subSums.get(i)+" ");
        }

        int result = 0;
        int mod = 1_000_000_007;

        for(int i = left-1 ; i < right; i++){
            result = (result + subSums.get(i)) % mod;
        }

        return result;
    }
}