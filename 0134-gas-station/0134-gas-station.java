class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int currentGas = 0;
        int totalGas = 0;
        int startStation = 0;
        int i = 0;
        while(i < gas.length){
            int diff = gas[i] - cost[i];
            currentGas += diff;
            totalGas += diff;
            if(currentGas < 0){
                currentGas = 0;
                startStation = i + 1;
            }
            i++;
        }

        if(totalGas >= 0){
            return startStation;
        }
            
        return -1;   
    }
}