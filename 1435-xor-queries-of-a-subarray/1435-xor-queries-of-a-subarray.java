class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];

        for(int i = 1; i < n; i++){
            prefixXor[i] = arr[i] ^ prefixXor[i-1];
        }

        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int L = queries[i][0];
            int R = queries[i][1];

            if(L == 0){
                result[i] = prefixXor[R];
            }else{
                result[i] = prefixXor[R] ^ prefixXor[L-1];
            }
        }

        return result;
    }
}