class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        String[] numString = new String[n];

        for(int i = 0; i < n; i++){
            numString[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numString, new Comparator<String>(){
            public int compare(String a, String b){
                String o1 = a+b;
                String o2 = b+a;
                return o2.compareTo(o1);
            }
        });

        if(numString[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : numString){
            sb.append(s);
        }

        return sb.toString();
    }
}