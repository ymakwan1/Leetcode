class Solution {
    public int findComplement(int num) {
        int bitLen = Integer.toBinaryString(num).length();

        int mask = (1 << bitLen) - 1;

        return num ^ mask;
    }
}