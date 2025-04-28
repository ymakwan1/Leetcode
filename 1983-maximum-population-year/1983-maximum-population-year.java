class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];

        for(int[] log : logs){
            population[log[0] - 1950]++;
            population[log[1] - 1950]--;
        }

        int maxPopulation = 0, currentPopulation = 0;
        int year = 1950;

        for(int i = 0; i < 101; i++){
            currentPopulation += population[i];
            if(currentPopulation > maxPopulation){
                maxPopulation = currentPopulation;
                year = 1950 + i;
            }
        }

        return year;
    }
}