class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int count = 0;
        //Brute
        // for(int i = 0; i < n; i++){
        //     for(int j = i; j < n; j++){
        //         if(isValid(word.substring(i, j + 1))){
        //             count++;
        //         }
        //     }
        // }

        //Better
        // Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        // for(int i = 0; i < n; i++){
        //     Set<Character> present = new HashSet<>();
        //     for(int j = i; j < n; j++){
        //         char c = word.charAt(j);
        //         if(!vowels.contains(c)){
        //             break;
        //         }
        //         present.add(c);
        //         if(present.size() == 5){
        //             count++;
        //         }
        //     }
        // }

        // Optimal
        for (int i = 0; i < n; i++) {
            if (!isVowel(word.charAt(i))) continue;
            int[] freq = new int[5];
            int distinct = 0;
            for (int j = i; j < n; j++) {
                char c = word.charAt(j);
                if (!isVowel(c)) break;

                if (freq[getIndex(c)] == 0) distinct++;
                freq[getIndex(c)]++;

                if (distinct == 5) count++;
            }
        }

        return count;

        
    }

    private boolean isValid(String s){
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        Set<Character> present = new HashSet<>();

        for(char c: s.toCharArray()){
            if(!vowels.contains(c)){
                return false;
            }
            present.add(c);
        }
        return present.size() == 5;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    private int getIndex(char c) {
        return "aeiou".indexOf(c);
    }
}