class Solution {
    public int majorityElement(int[] nums) {
        int elem = 0;
        int count = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){
            if(count == 0){
                elem = nums[i];
                count = 1;
            }else if(nums[i] == elem){
                count++;
            }else{
                count--;
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(elem == nums[i]){
                cnt++;
            }
        }
        if(cnt > (n/2)){
            return elem;
        }
        return -1;
    }
}