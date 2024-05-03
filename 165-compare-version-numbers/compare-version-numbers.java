class Solution {
    public int compareVersion(String version1, String version2) {
        String[] version1Arr = version1.split("\\.");
        String[] version2Arr = version2.split("\\.");

        int i = version1Arr.length;
        int j = version2Arr.length;
        int v1 = 0;
        int v2 = 0;

        while(v1 < i || v2 < j){
            int num1 = (v1 < i) ? Integer.parseInt(version1Arr[v1]) : 0;
            int num2 = (v2 < j) ? Integer.parseInt(version2Arr[v2]) : 0;
            
            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }

            v1++;
            v2++;
        }

        return 0;
    }
}