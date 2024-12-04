class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int i = 0, j = 0;

        while (i < n && j < m) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);

            if (ch1 == ch2 || (ch1 + 1 - 'a') % 26 + 'a' == ch2) {
                j++; //Move to the next character in str2
            }
            i++; //Always move to the next character in str1
        }

        return j == m;
    }
}
