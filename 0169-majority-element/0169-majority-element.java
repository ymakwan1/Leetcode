import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, max = nums[0];
        
        for(int i = 0 ; i < nums.length ; i++) {
            if (max == nums[i]) {
                count++;
            } else {
                count--;
            }
            
            if(count == 0){
                max = nums[i];
                count=1;
            }
        }
        return max;
     }
}