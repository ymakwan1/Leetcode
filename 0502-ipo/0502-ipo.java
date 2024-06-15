class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;

        int[][] projects = new int[n][2];

        for(int i = 0; i < n; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, Comparator.comparingInt(a -> a[0]));
       
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int index = 0;
        for(int i = 0; i < k; i++){
            while (index < n && projects[index][0] <= w) {
                pq.add(projects[index][1]);
                index++;
            }

            if (pq.isEmpty()) {
                break;
            }

            w += pq.poll();
        }

        return w;
    }
}