class Solution {
    public int totalFruit(int[] fruits) {
        int maxLen = 0;
        Map<Integer, Integer> fruitCount = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = fruits.length;

        while (right < n) {
            fruitCount.put(fruits[right], fruitCount.getOrDefault(fruits[right], 0) + 1);

            while (fruitCount.size() > 2) {
                fruitCount.put(fruits[left], fruitCount.get(fruits[left]) - 1);
                if (fruitCount.get(fruits[left]) == 0) {
                    fruitCount.remove(fruits[left]);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}