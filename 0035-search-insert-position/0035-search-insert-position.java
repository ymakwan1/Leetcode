class Solution {
    public int searchInsert(int[] nums, int target) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums) {
            arrayList.add(num);
        }
        
        if(arrayList.contains(target)) {
            return arrayList.indexOf(target);
        } else if (target > arrayList.get(arrayList.size() - 1)) {
            return arrayList.size();
        } else {
            for(int i = 0; i < arrayList.size(); i++) {
                if (!(arrayList.get(i) < target)) {
                    return i;
                }
            }
        }
        return 0;
    }
}