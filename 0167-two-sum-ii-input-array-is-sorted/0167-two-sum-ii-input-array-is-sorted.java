 class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            int targetSum = numbers[left] + numbers[right];

            if(target > targetSum){
                left++;
            } else if (target < targetSum){
                right--;
            }else{
                return new int[]{left+1, right+1};
            }
        }

        return new int[]{0};
    }
}