class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;  // Initialize the result as 0/1

        // Split the expression by '+' and '-' to parse the fractions
        for (int i = 0; i < expression.length(); ) {
            int sign = 1;
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            // Parse the numerator
            int n = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                n = n * 10 + (expression.charAt(i) - '0');
                i++;
            }
            n *= sign;

            // Skip the '/' character
            i++;

            // Parse the denominator
            int d = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                d = d * 10 + (expression.charAt(i) - '0');
                i++;
            }

            // Compute the new numerator and denominator using the common denominator
            numerator = numerator * d + n * denominator;
            denominator *= d;

            // Simplify the fraction using GCD
            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    // Helper function to calculate GCD
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
