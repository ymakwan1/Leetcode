class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450"; //Target state
        StringBuilder start = new StringBuilder();
        
        for (int[] row : board) {
            for (int num : row) {
                start.append(num);
            }
        }

        int[][] neighbors = {
            {1, 3},     //0 can swap with 1, 3
            {0, 2, 4},  //1 can swap with 0, 2, 4
            {1, 5},     //2 can swap with 1, 5
            {0, 4},     //3 can swap with 0, 4
            {1, 3, 5},  //4 can swap with 1, 3, 5
            {2, 4}      //5 can swap with 2, 4
        };

        //BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }

                //Find the position of '0'
                int zeroIndex = current.indexOf('0');

                //Swap with neighbors
                for (int neighbor : neighbors[zeroIndex]) {
                    String swapped = swap(current, zeroIndex, neighbor);
                    if (!visited.contains(swapped)) {
                        visited.add(swapped);
                        queue.offer(swapped);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    //Helper function to swap characters in a string
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}