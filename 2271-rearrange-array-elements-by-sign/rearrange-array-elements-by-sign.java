class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();
        int[] r = new int[n];
        for(int i : nums){
            if(i < 0){
                negative.add(i);
            }else {
                positive.add(i);
            }
        }
        int j = 0;
        int i = 0;
        //for(int j = 0;  j < positive.size(); j++){
        while(j < n){
            r[j] = positive.get(i);
            r[j+1] = negative.get(i);
            j += 2;
            i++;
            // System.out.println(positive.get(j));
            // System.out.println(negative.get(j));
        }
        return r;
    }
}