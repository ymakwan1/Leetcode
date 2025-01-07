class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if(words[j].contains(words[i])){
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }
}