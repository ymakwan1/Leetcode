class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        int count = 0;
        //Brute
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isValid(word.substring(i, j + 1))){
                    count++;
                }
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
}