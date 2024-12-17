class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++){
            if(freq[i] > 0){
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int charIndex = curr[0];
            int charFreq = curr[1];
            char currChar = (char)(charIndex + 'a');

            int count = Math.min(repeatLimit, charFreq);
            for(int i = 0; i < count; i++){
                result.append(currChar);
            }

            charFreq -= count;
            if(charFreq > 0){
                if(pq.isEmpty()){
                    break;
                }

                int[] next = pq.poll();
                int nextCharIndex = next[0];
                int nextCharFreq = next[1];
                char nextChar = (char)(nextCharIndex + 'a');

                result.append(nextChar);
                nextCharFreq--;

                if(nextCharFreq > 0){
                    pq.offer(new int[] {nextCharIndex, nextCharFreq});
                }
                pq.offer(new int[] {charIndex, charFreq });
            }
        }

        return result.toString();
    }
}