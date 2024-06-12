class Solution {
    public int totalFruit(int[] fruits) {
        int maxLen = 0;
        int[] hash = new int[1000001];
        int left = 0;
        int right = 0;
        int n = fruits.length;
        int uniqueCount = 0;

        while(right < n){

            if(hash[fruits[right]] == 0){
                uniqueCount++;
            }
            hash[fruits[right]]++;

            while (uniqueCount > 2) {
                hash[fruits[left]]--;
                if (hash[fruits[left]] == 0) {
                    uniqueCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}