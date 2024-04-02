class Solution {
    public void moveZeroes(int[] nums) {
       int count = 0;
       ArrayList<Integer> temp = new ArrayList<>();
       for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp.add(nums[i]);
            }else {
                count++;
            }
       }

       for (int i = 0; i < count; i++) {
            temp.add(0);
       }


        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp.get(i);
        }
    }
}