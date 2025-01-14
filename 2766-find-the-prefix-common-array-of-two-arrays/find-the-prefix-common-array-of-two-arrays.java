class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int commonCount = 0;
        int[] freq = new int[51];
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            freq[A[i]]++;
            freq[B[i]]++;

            if(freq[A[i]] == 2){
                commonCount++;
            }
            if(A[i] != B[i] && freq[B[i]] == 2){
                commonCount++;
            }

            result[i] = commonCount;
        }

        return result;
    }
}