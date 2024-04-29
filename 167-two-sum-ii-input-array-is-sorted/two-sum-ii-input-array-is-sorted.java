class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0;
        int end = n - 1;
        int sum = 0;

        int[] result = new int[2];

        while(start <= end){
            sum = numbers[start] + numbers[end];
            if(sum == target){
                result[0] = start+1;
                result[1] = end+1;
                break;
            } else if (sum > target){
                end--;
            } else {
                start++;
            }
        }

        return result;
    }
}