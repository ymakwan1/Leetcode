class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (i<words.length) {
            for(char c : words[i].toCharArray()) {
                if (c == x) {
                    result.add(i);
                    break;
                }
            }
            i++;
        }
        return result;
    }
}