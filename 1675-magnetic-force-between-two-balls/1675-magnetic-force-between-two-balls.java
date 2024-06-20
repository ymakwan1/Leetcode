class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int n = position.length;
        int left = 1;
        int right = position[n-1] - position[0];
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canPlaceBalls(position, m, mid)) {
                result = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canPlaceBalls(int[] position, int m, int minDist){
        int count = 1;
        int lastPos = position[0];

        for (int i = 0; i < position.length; i++) {
            if (position[i] - lastPos >= minDist) {
                count++;
                lastPos = position[i];
                if(count == m){
                    return true;
                }
            }
        }
        return false;
    }
}