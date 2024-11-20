class Solution {
    public int takeCharacters(String s, int k) {
        int[] total = new int[3];
        for (char ch : s.toCharArray()) {
            total[ch - 'a']++;
        }

        for (int count : total) {
            if (count < k) {
                return -1;
            }
        }

        int n = s.length();
        int[] current = new int[3]; 
        int left = 0, maxWindow = 0;

        for (int right = 0; right < n; right++) {
            current[s.charAt(right) - 'a']++;

            while (current[0] > total[0] - k || current[1] > total[1] - k || current[2] > total[2] - k) {
                current[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }
}
