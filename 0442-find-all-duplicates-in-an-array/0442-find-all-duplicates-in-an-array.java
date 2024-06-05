class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        List<Integer> res = new ArrayList<>();

        if (n == 1) {
            return res;
        }

        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
        }

        for (int i = 0; i <= n; i++) {
            if (arr[i] == 2) {
                res.add(i);
            }
        }

        return res;
    }
}
