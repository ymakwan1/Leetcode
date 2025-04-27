class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000")) return -1;

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer("0000");
        visited.add("0000");

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int s = 0; s < size; s++) {
                String curr = queue.poll();

                if(curr.equals(target)){
                    return moves;
                }

                for (String next : getNextStates(curr)) {
                    if(!dead.contains(next) && !visited.contains(next)){
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }

    private List<String> getNextStates(String state){
        List<String> nextStates = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            char[] chars = state.toCharArray();
            chars[i] = chars[i] == '9' ? '0' : (char)(chars[i] + 1);
            nextStates.add(new String(chars));

            chars = state.toCharArray();
            chars[i] = chars[i] == '0' ? '9' : (char)(chars[i] - 1);
            nextStates.add(new String(chars));
        }

        return nextStates;
    }
}