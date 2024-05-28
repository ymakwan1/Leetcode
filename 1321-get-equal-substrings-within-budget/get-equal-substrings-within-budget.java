class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0, right = 0;
        int currentCost = 0;
        int maxLength = 0;

        while (right < n) {
            // Add the cost of converting s[right] to t[right]
            currentCost += Math.abs(s.charAt(right) - t.charAt(right));

            // If the currentCost exceeds the maxCost, move the left pointer to the right
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            // Calculate the length of the current window and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}
