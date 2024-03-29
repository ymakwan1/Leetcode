class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int[] count = new int[256];
        int totalCount = 0;

        for (char j : jewels.toCharArray()) {
            for (char s : stones.toCharArray()) {
                if (s == j) {
                    totalCount++;
                }
            }
        }

        return totalCount;
    }
}