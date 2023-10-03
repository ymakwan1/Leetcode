class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<String>();
        
        for(String s :  nums){
            set.add(s);
        }
        
        int stringLength = nums[0].length();
        StringBuilder uniqueString = new StringBuilder();
        
        boolean foundUnique = findUniqueString(set, stringLength, uniqueString);
        
        return foundUnique ? uniqueString.toString() : "";
    }
    
    public boolean findUniqueString(Set<String> set, int stringLength, StringBuilder uniqueString){
        if(uniqueString.length() >= stringLength){
            String currentUniqueString = uniqueString.toString();
            if(!set.contains(currentUniqueString)){
                return true;
            }
            return false;
        }
        
        uniqueString.append('0');
        if(findUniqueString(set, stringLength, uniqueString)){
            return true;
        }
        uniqueString.deleteCharAt(uniqueString.length() - 1);
        
        uniqueString.append('1');
        if(findUniqueString(set, stringLength, uniqueString)){
            return true;
        }
        uniqueString.deleteCharAt(uniqueString.length() - 1);
        
        return false;
    }
}