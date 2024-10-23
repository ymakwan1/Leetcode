class Solution {
    public long minimumSteps(String s) {
        long swaps = 0;
        int blackCount = 0;
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                blackCount++;
            }else{
                swaps += blackCount;
            }
        }

        return swaps;
    }
}