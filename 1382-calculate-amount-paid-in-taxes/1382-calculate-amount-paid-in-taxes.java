class Solution {
    public double calculateTax(int[][] brackets, int income) {
    double totalTax = 0.0;
    int remainingIncome = income;

    for (int i = 0; i < brackets.length; i++) {
        int upper = brackets[i][0];
        double percent = brackets[i][1] / 100.0; // Convert percent to decimal

        int taxableIncome = Math.min(upper - (i == 0 ? 0 : brackets[i - 1][0]), remainingIncome);
        double taxAmount = taxableIncome * percent;
        
        totalTax += taxAmount;
        remainingIncome -= taxableIncome;
    }

    return totalTax;
}

}