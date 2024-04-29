class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int start = 0;
        int end = n - 1;
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int[] result = new int[2];

        while(start <= end){
            sum = numbers[start] + numbers[end];
            if(sum == target){
                // res.add(start);
                // res.add(end);
                result[0] = start+1;
                result[1] = end+1;
                break;
            } else if (sum > target){
                end--;
            } else {
                start++;
            }
        }

        // int[] arr = new int[res.size()];
        // arr = al.toArray(arr);
        return result;
    }
}