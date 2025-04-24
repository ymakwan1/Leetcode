class Solution {
    public boolean checkIfPangram(String sentence) {
        int zeroCount = 26;
        boolean[] seen = new boolean[26];

        for (char c : sentence.toCharArray()) {
            if(!seen[c - 'a']){
                seen[c - 'a'] = true;
                zeroCount--;

                if (zeroCount == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}