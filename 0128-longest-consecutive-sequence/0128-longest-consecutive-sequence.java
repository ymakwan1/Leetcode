class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        //int count = 0;
        int seqCount = 0;
        int lastSmaller = Integer.MIN_VALUE;

        //Better approach
        // Arrays.sort(nums);
        // for(int i = 0; i < n; i++){
        //     if(nums[i] - 1 == lastSmaller){
        //         count++;
        //         lastSmaller = nums[i];
        //     }else if(nums[i] != lastSmaller){
        //         count = 1;
        //         lastSmaller = nums[i];
        //     }
        //     seqCount = Math.max(seqCount, count);
        // }

        //Optimal
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        for(Integer i : set){
            if(!set.contains(i-1)){
                int count = 1;
                int x = i;
                while(set.contains(x+1)){
                    x = x + 1;
                    count++;
                }
                seqCount = Math.max(seqCount, count);
            }
        }

        return seqCount;
    }
}