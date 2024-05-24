class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        // freq for available letters
        int[] letterCounts = new int[26];
        for(char l : letters){
            letterCounts[l-'a']++;
        }

        //backtrack
        return backtrack(words, letterCounts, score, 0);
    }

    private int backtrack(String[] words, int[] letterCount, int[] score, int index){
        if(index == words.length){
            return 0;
        }

        //Skip current word
        int maxScore = backtrack(words, letterCount, score, index+1);

        //Use current word
        String word = words[index];
        int wordScore = 0;
        boolean canUseWord = true;
        int[] tempCount = Arrays.copyOf(letterCount, letterCount.length);

        for(char c : word.toCharArray()){
            if (tempCount[c - 'a']-- <= 0) {
                canUseWord = false;
                break;
            }
            wordScore += score[c - 'a'];
        }

        if(canUseWord){
            maxScore = Math.max(maxScore, wordScore + backtrack(words, tempCount, score, index+1));
        }

        return maxScore;
    }
}