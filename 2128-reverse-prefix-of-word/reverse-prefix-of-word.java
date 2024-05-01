class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);

        StringBuilder result = new StringBuilder(word.substring(0, index+1));
        System.out.println(index);
        System.out.println(result.reverse().append(word.substring(index+1, word.length())).toString());

        return result.toString();
    }
}