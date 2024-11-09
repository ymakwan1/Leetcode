class Solution {
    public long minEnd(long n, long x) {
        if (n == 1) {
            return x;
        }
        n--;
        long j = 0;
        for (long i = 0; i < 64; i++) {
            long bit = (x >> i) & 1L;
            if (bit == 0) {
                // can place
                long nbit = (n >> j) & 1L;
                if (nbit == 1) {
                    x |= (1L << i);
                }
                j++;
            }
        }
        return x;
    }
}