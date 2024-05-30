class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] prefixXOR = new int[n+1];

        // Calculate prefix xors
        for(int i = 0; i < n; i++){
            prefixXOR[i+1] = prefixXOR[i] ^ arr[i];
        }

        int count = 0;
        // Go over all possible values of j
        for(int j = 0; j < n; j++){
            // Check pairs with given conditions
            for(int k = j+1; k <= n; k++){
                if(prefixXOR[j] == prefixXOR[k]){
                    count += (k - j - 1);
                }
            }
        }

        return count;
    }
}