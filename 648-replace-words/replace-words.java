class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dictSet = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();

        for(String word : words){
            String prefix = "";
            for(int i = 1; i <= word.length(); i++){
                prefix = word.substring(0, i);
                if(dictSet.contains(prefix)){
                    break;
                }
            }

            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(dictSet.contains(prefix) ? prefix : word);
        }

        return result.toString();
    }
}