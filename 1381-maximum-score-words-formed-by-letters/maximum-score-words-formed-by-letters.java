class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        // frequency array for the available letters
        int[] letterCount = new int[26];
        for (char letter : letters) {
            letterCount[letter - 'a']++;
        }
        
        // backtracking to find the maximum score
        return backtrack(words, letterCount, score, 0, 0);
    }

    private int backtrack(String[] words, int[] letterCount, int[] score, int index, int currentScore) {
        if (index == words.length) {
            return currentScore;
        }

        // Skip the current word
        int maxScore = backtrack(words, letterCount, score, index + 1, currentScore);

        // use the current word
        String word = words[index];
        int wordScore = 0;
        boolean canUseWord = true;
        int[] tempCount = Arrays.copyOf(letterCount, letterCount.length);

        for (char c : word.toCharArray()) {
            if (tempCount[c - 'a']-- <= 0) {
                canUseWord = false;
                break;
            }
            wordScore += score[c - 'a'];
        }

        if (canUseWord) {
            maxScore = Math.max(maxScore, backtrack(words, tempCount, score, index + 1, currentScore + wordScore));
        }

        return maxScore;
    }
}