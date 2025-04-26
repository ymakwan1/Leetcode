class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1){
            return x;
        }

        int left = 1, right = x / 2, ans = 1;
        while (left <= right) {
            int mid = (left+right) / 2;

            if(mid <= (x / mid)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }
}