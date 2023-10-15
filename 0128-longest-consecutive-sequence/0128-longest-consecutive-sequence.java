class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int d : nums){
            if(!set.contains(d))
                set.add(d);
        }

        int longestStreak = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int current = num;
                int currentStreak = 1;

                while(set.contains(current+1)){
                    current++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}