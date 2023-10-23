class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int currentGas = 0;
        int totalGas = 0;
        int startStation = 0;
        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            currentGas += diff;
            totalGas += diff;
            if(currentGas < 0){
                currentGas = 0;
                startStation = i + 1 ;
            }
        }

        if(totalGas >= 0){
            return startStation;
        } else {
            return -1;
        }   
    }
}