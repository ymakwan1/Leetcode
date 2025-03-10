class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        //Brute
        // for(int i = 0; i < n; i++){
        //     if(result.size() == 0 || result.get(0) != nums[i]){
        //         int count = 0;
        //         for(int j = 0; j < n; j++){
        //             if(nums[j] == nums[i]){
        //                 count++;
        //             } 
        //         }
        //         if(count > (n/3)){
        //             result.add(nums[i]);
        //         }
        //         if(result.size() == 2){
        //             break;
        //         }
        //     }
        // }

        //Better
        HashMap<Integer, Integer> map = new HashMap<>();
        int minValue = (int)(Math.floor(n/3) + 1);

        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.get(nums[i]) == minValue){
                result.add(nums[i]);
            }
        }
    

        //Optimal
        //potential candidates
        // int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;
        // int count1 = 0, count2 = 0;

        // for (int num : nums) {
        //     if (num == candidate1) {
        //         count1++;
        //     } else if (num == candidate2) {
        //         count2++;
        //     } else if (count1 == 0) {
        //         candidate1 = num;
        //         count1 = 1;
        //     } else if (count2 == 0) {
        //         candidate2 = num;
        //         count2 = 1;
        //     } else {
        //         count1--;
        //         count2--;
        //     }
        // }

        // //Verify if they are valid majority elements
        // count1 = 0;
        // count2 = 0;
        // for (int num : nums) {
        //     if (num == candidate1) count1++;
        //     else if (num == candidate2) count2++;
        // }

        
        // if (count1 > n / 3) result.add(candidate1);
        // if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}