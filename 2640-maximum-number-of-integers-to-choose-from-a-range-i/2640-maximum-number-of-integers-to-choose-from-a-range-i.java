class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();

        for(int num : banned){
            set.add(num);
        }

        int count = 0;
        int currentSum = 0;

        for(int i = 1; i <= n; i++){
            if(set.contains(i)){
                continue;
            }

            if(currentSum + i > maxSum){
                break;
            }

            currentSum += i;
            count++;
        }

        return count;
    }
}