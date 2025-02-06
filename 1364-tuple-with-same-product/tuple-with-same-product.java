class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productFreq = new HashMap<>();
        int n = nums.length;
        int count = 0;

        //Compute product of all pairs and store in hashmap
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productFreq.put(product, productFreq.getOrDefault(product, 0) + 1);
            }
        }

        //Count valid tuples
        for (int freq : productFreq.values()) {
            if (freq > 1) {
                count += (freq * (freq - 1) / 2) * 8;  //C(freq, 2) * 8 permutations
            }
        }

        return count;
    }
}