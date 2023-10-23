class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] map = new int[26];

        for(char s : sentence.toCharArray()){
            map[s - 'a'] = map[s-'a'] + 1;
        }

        for(int i = 0; i < map.length; i++){
            if(map[i] == 0){
                return false;
            }
        }

        return true;
    }
}