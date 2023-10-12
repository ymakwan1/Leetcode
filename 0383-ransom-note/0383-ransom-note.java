class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> mag = new HashMap<>();

        for(char m : magazine.toCharArray()){
            if(!mag.containsKey(m)){
                mag.put(m, 1);
            } else {
                int val = mag.get(m);
                mag.put(m, val + 1);
            }
        }
        for(char r : ransomNote.toCharArray()){
            if(mag.containsKey(r)){
                int count = mag.get(r);

                if(count > 0){
                    mag.put(r, count - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}