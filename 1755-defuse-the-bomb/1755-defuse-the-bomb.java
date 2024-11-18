class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        //k is 0 result array should be all zeros
        if (k == 0) {
            return result;
        }
        
        int sum = 0, start, end;
        
        //For k > 0 sum the next k elements
        if (k > 0) {
            
            start = 1;
            end = k;
        }
        //For k < 0 sum the previous k elements
        else {
            
            start = n + k;
            end = n - 1;
            k = -k; //absolute value of k
        }
        
        //The sum for the first window
        for (int i = start; i <= end; i++) {
            sum += code[i % n];
        }
        
        //Iterate through the array and compute the result for each index.
        for (int i = 0; i < n; i++) {
            result[i] = sum;
            //Update the sliding window.
            sum -= code[start % n];
            sum += code[(end + 1) % n];
            start++;
            end++;
        }
        
        return result;
    }
}
