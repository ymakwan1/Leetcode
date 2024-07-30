class Solution {
    public int minimumDeletions(String s) {
        int rightA = 0;
        int leftB = 0;
        int minDeletions = Integer.MAX_VALUE;

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                rightA++;
            }
        }

        for (char c : s.toCharArray()) {
            if (c == 'a') {
                rightA--;
            }
            minDeletions = Math.min(minDeletions, leftB + rightA);
            if (c == 'b') {
                leftB++;
            }
        }

        return minDeletions;
    }
}
