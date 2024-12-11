class Solution {
    public int maximumBeauty(int[] nums, int k) {
        List<int[]> events = new ArrayList<>();

        for (int num : nums) {
            events.add(new int[] {num - k, 1}); 
            events.add(new int[] {num + k + 1, -1});
        }

        events.sort((a, b) -> (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));

        int maxBeauty = 0;
        int currentOverlap = 0;

        for (int[] event : events) {
            currentOverlap += event[1];
            maxBeauty = Math.max(maxBeauty, currentOverlap); 
        }

        return maxBeauty;
    }
}