class Solution {
    public int numOfSubarrays(int[] arr) {
        int evenCount = 1;
        int oddCount = 0;
        int prefixSum = 0;
        int MOD = 1_000_000_007;
        int result = 0;

        for(int num : arr){
            prefixSum += num;

            if(prefixSum % 2 == 1){
                result = (result + evenCount) % MOD;
                oddCount++;
            }else{
                result = (result + oddCount) % MOD;
                evenCount++;
            }
        }
        return result;
    }
}