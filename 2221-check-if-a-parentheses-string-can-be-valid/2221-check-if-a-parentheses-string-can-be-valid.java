class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;

        int open = 0, flexible = 0;

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') open++;
                else open--;
            } else {
                flexible++;
            }
            if (open < -flexible) return false;
        }

        open = 0; 
        flexible = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') open++;
                else open--;
            } else {
                flexible++;
            }
            if (open < -flexible) return false;
        }

        return true;
    }
}
