class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] result = new int[n];
        int leftCount = 0;
        int leftOps = 0;

        for(int i = 0; i < n; i++){
            result[i] += leftOps;
            if(boxes.charAt(i) == '1'){
                leftCount++;
            }
            leftOps += leftCount;
        }

        int rightCount = 0;
        int rightOps = 0;
        for(int i = n-1; i >=0; i--){
            result[i] += rightOps;
            if(boxes.charAt(i) == '1'){
                rightCount++;
            }
            rightOps += rightCount;
        }

        return result;
    }
}