class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int alwaysSatisfied = 0;

        // customers that are always satisfied
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                alwaysSatisfied += customers[i];
            }
        }

        // number of additional customers that can be satisfied
        // during the initial window of size miniutes
        int additionalSatisfied = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
        }

        int maxAdditionalSatisfied = additionalSatisfied;

        // Slide the window from the start to the end
        for (int i = minutes; i < n; i++) {
            if (grumpy[i] == 1) {
                additionalSatisfied += customers[i];
            }
            if (grumpy[i - minutes] == 1) {
                additionalSatisfied -= customers[i - minutes];
            }
            maxAdditionalSatisfied = Math.max(maxAdditionalSatisfied, additionalSatisfied);
        }

        // The total number of satisfied customers is the sum of always satisfied
        // customers and the maximum number of additional satisfied customers
        return alwaysSatisfied + maxAdditionalSatisfied;
    }
}