class Solution {
    public boolean checkRecord(String s) {
        int countA = 0; // Count A's
        int continuousL = 0; //Count L's

        // Go over the string to count occurence condition
        for(char c : s.toCharArray()){
            if(c == 'A'){
                countA++;
                if(countA > 1){
                    return false; // More than one A
                }
            }
            if(c == 'L'){
                continuousL++;
                if(continuousL > 2){
                    return false; // More than 2 L's continously
                }
            }else{
                continuousL = 0; //Reset if not continous
            }
        }
        // If no more than 1 A and no more than 2 continuous L
        return true;
    }
}