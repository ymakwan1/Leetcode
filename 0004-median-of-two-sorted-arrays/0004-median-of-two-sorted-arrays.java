class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0.0;
        int mergedLength = nums1.length + nums2.length;
        int[] mergedArray = new int[mergedLength];
        
        System.arraycopy(nums1, 0, mergedArray, 0, nums1.length);
        System.arraycopy(nums2, 0, mergedArray, nums1.length, nums2.length);
        
        Arrays.sort(mergedArray);
        
        if (mergedLength % 2 != 0) {
            result = mergedArray[mergedArray.length / 2];
        } else {
            result = (float)(mergedArray[mergedArray.length / 2] + mergedArray[(mergedArray.length / 2) - 1]) / 2;
        }
        return result;
    }
}