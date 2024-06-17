class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false; 
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i <= Math.sqrt(c); i++) {
            int square = i * i;
            if (square * 2 == c || set.contains(c - square)) {
                return true;
            }
            set.add(square);
        }
        
        return false;
    }
}
