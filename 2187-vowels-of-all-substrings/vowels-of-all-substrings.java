class Solution {
    public long countVowels(String word) {
        long totalCount = 0;
        int n = word.length();

        for(int i = 0; i < n; i++){
            if(word.charAt(i) == ('a') || word.charAt(i) == ('e') || word.charAt(i) == ('i') || word.charAt(i) == ('o') || word.charAt(i) ==('u')){

                totalCount += (long)(i + 1) * (n - i);
            }
        }

        return totalCount;
    }
}