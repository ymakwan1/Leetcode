public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        int maxElement = 0;
        for (int num : nums1) {
            maxElement = Math.max(maxElement, num);
        }
        
        int[] freq = new int[maxElement + 1];
        for (int num : nums1) {
            freq[num]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (num <= maxElement && freq[num] > 0) {
                result.add(num);
                freq[num]--;
            }
        }

        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}