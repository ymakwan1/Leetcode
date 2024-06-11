class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();

        if (k > n) {
            return -1;
        }

        int whiteCount = 0;
        int minRecolors = Integer.MAX_VALUE;

        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }
        
        minRecolors = whiteCount;

        for (int i = k; i < n; i++) {
            
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }

            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }

            minRecolors = Math.min(minRecolors, whiteCount);
        }

        return minRecolors;
    }
}
