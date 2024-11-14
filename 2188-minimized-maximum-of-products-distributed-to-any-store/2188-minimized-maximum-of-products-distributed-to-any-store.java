class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();

        while(left < right){
            int mid = left + (right - left) / 2;
            if(canDistribute(quantities, n, mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canDistribute(int[] products, int stores, int maxProductsPerStore){
        int requiredStones = 0;
        for(int productCount : products){
            requiredStones += (productCount + maxProductsPerStore - 1) / maxProductsPerStore;
            if(requiredStones > stores){
                return false;
            }
        }
        return true;
    }
}