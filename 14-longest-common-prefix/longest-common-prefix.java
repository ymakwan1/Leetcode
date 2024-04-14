class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();

        // Edge cases
        if(strs.length == 0){
            return "";
        } else if(strs.length == 1){
            return strs[0];
        }

        //Find min length among all strings
        int min = Integer.MAX_VALUE;
        for(String str : strs){
            min = Math.min(min, str.length());
        }

        //Compare chars at each pos in all strings
        for(int i = 0;  i < min; i++){
            char currChar = strs[0].charAt(i); //Char at curr pos
            boolean isCommon = true; // Flag to check same char or not

            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) != currChar){
                    isCommon = false;
                    break;
                }
            }

            //Common char append
            if(isCommon){
                commonPrefix.append(currChar);
            } else { // or else break
                break;
            }
        }

        return commonPrefix.toString();
    }
}