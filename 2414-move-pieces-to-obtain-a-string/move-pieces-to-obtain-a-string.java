class Solution {
    public boolean canChange(String start, String target) {
        String startWithoutUnderscore = start.replace("_", "");
        String targetWithoutUnderscore = target.replace("_", "");

        if(!startWithoutUnderscore.equals(targetWithoutUnderscore)){
            return false;
        }

        int startP = 0;
        int targetP = 0;
        int n = start.length();

        while(startP < n && targetP < n){
            while (startP < n && start.charAt(startP) == '_') {
                startP++;
            }

            while (targetP < n && target.charAt(targetP) == '_') {
                targetP++;
            }

            if(startP == n || targetP == n){
                break;
            }

            if(start.charAt(startP) != target.charAt(targetP)){
                return false;
            }

            if (start.charAt(startP) == 'L' && startP < targetP) {
                return false; 
            }
            
            if (start.charAt(startP) == 'R' && startP > targetP) {
                return false; 
            }
            
            startP++;
            targetP++;
        }

        return true;
    }
}