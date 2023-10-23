class Solution {
    public boolean checkIfPangram(String sentence) {
        // int[] map = new int[26];
Set<Character> set = new HashSet<>();
        for(char s : sentence.toCharArray()){
            //map[s - 'a'] = map[s-'a'] + 1;
            set.add(s);
        }

        if(set.size() == 26){
            return true;
        }
        return false;

        // for(int i = 0; i < map.length; i++){
        //     if(map[i] == 0){
        //         return false;
        //     }
        // }

        // return true;
        

    }
}