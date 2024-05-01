class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        StringBuilder result = new StringBuilder();
        result.append(word.substring(0, index+1)).reverse().append(word.substring(index+1, word.length()));

        return result.toString();
    }
}