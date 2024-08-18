class Solution {
    public int nthUglyNumber(int n) {
        // Array to store the first n ugly numbers
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1; // The first ugly number is 1// Initialize three pointers for multiples of 2, 3, and 5
        int i2=0, i3 = 0, i5 = 0;
        
        // Initialize the next multiples for 2, 3, and 5 
        int nextMultipleOf2=2;
        int nextMultipleOf3=3;
        int nextMultipleOf5=5;
        
        for(int i=1; i < n; i++) {
            // Choose the smallest among the next multiples
            int nextUglyNumber= Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUglyNumber;
            
            // Update the multiples for 2, 3, or 5 based on which one was used 
            if (nextUglyNumber == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }
            if (nextUglyNumber == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }
            if (nextUglyNumber == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }
        
        // The nth ugly number is now at the last index
        return uglyNumbers[n - 1];
    }
}
