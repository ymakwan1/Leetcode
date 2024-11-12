class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] answer = new int[queries.length];

        //Sort by price
        Arrays.sort(items, (a,b) -> Integer.compare(a[0], b[0]));

        //(query, og index) to track og position
        int[][] queryPairs = new int[queries.length][2];
        for(int i = 0; i < queries.length; i++){
            queryPairs[i][0] = queries[i];
            queryPairs[i][1] = i;
        }

        //Sort by query value
        Arrays.sort(queryPairs, (a, b) -> Integer.compare(a[0], b[0]));

        int maxBeauty = 0;
        int itemIndex = 0;

        for(int[] query : queryPairs){
            int queryPrice = query[0];
            int ogIndex = query[1];

            while (itemIndex < items.length && items[itemIndex][0] <= queryPrice) {
                maxBeauty = Math.max(maxBeauty, items[itemIndex][1]);
                itemIndex++;
            }

            answer[ogIndex] = maxBeauty;
        }

        return answer;
    }
}