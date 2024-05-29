class Solution {
    public List<String> buildArray(int[] target, int n) {
        int l = target.length;
        List<String> result = new ArrayList<>();
        int j = 0;
        for(int i = 1; i <=n; i++){
            if(i == target[j]){
                result.add("Push");
                j++;
            }else{
                result.add("Push");
                result.add("Pop");
            }

            if(j == l){
                return result;
            }
        }

        return result;
    }
}