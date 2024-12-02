class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        //Split the sentence into words
        String[] words = sentence.split(" ");
        
        //Iterate through the words
        for (int i = 0; i < words.length; i++) {
            //Check if the current word starts with the searchWord
            if (words[i].startsWith(searchWord)) {
                //Return the 1-based index of the word
                return i + 1;
            }
        }
        
        //If no match is found, return -1
        return -1;
    }
}