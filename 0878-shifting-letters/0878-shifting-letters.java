class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] result = s.toCharArray();
        int totalShift = 0;

        //Traverse the shifts array in reverse to calculate cumulative shifts
        for (int i = n - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26; // Keep shift within bounds
            //Shift the character
            result[i] = (char) ('a' + (result[i] - 'a' + totalShift) % 26);
        }

        return new String(result);
    }
}
