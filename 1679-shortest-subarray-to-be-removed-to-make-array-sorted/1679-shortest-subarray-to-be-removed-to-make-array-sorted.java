class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        //Prefix
        int left = 0;
        while(left < n - 1 && arr[left] <= arr[left + 1]){
            left++;
        }

        //If complete array is already sorted
        if(left == n - 1){
            return 0;
        }

        //Suffix
        int right = n - 1;
        while(right > 0 && arr[right - 1] <= arr[right]){
            right--;
        }

        int i = 0;
        int j = right;
        int result = Math.min(n - left - 1, right);

        //Merge prefix and suffix
        while(i <= left && j < n){
            if(arr[i] <= arr[j]){
                result = Math.min(result, j - i - 1);
                i++;
            }else{
                j++;
            }
        }

        return result;

    }
}