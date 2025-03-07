class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int n : arr){
            if(set.contains(2 * n)){
                return true;
            }

            if(n % 2 == 0 && set.contains(n / 2)){
                return true;
            }

            set.add(n);
        }

        return false;
    }
}