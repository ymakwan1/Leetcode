class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int result = 0;
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1],a[1]));
        for (int[] is : boxTypes) {
            int unit = Math.min(is[0], truckSize);
            result = result + (is[1] * unit);
            truckSize -= unit;
        }
        return result;
    }
}