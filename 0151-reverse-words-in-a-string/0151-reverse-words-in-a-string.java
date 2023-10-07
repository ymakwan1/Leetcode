class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] words = s.split("\\s+");
        int start = 0;
        int end = words.length - 1;

        while (start < end) {
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }

        StringBuilder  stringBuilder = new StringBuilder();
        for (String string : words) {
            stringBuilder.append(string).append(" ");
        }

        return stringBuilder.toString().trim();
    }
}