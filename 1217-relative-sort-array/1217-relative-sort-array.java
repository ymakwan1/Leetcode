class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freqArr1 = new int[1001];
        ArrayList<Integer> result = new ArrayList<>();
        for(int n : arr1){
            freqArr1[n]++;
        }

        for (int num : arr2) {
            for (int j = 0; j < freqArr1[num]; j++) {
                result.add(num);
            }
            freqArr1[num] = 0; 
        }

        for (int i = 0; i < freqArr1.length; i++) {
            for (int j = 0; j < freqArr1[i]; j++) {
                result.add(i);
            }
        }

        int[] sortedArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            sortedArray[i] = result.get(i);
        }

        return sortedArray;

    }
}