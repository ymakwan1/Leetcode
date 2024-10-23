class Solution {
    private int maxCount = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<>());
        return maxCount;
    }

    private void backtrack(String s, int index, HashSet<String> used){
        //Return when index equates to total length
        if(index == s.length()){
            maxCount = Math.max(maxCount, used.size());
            return;
        }

        for(int i = index; i < s.length(); i++){
            String substring = s.substring(index, i + 1);
            if(!used.contains(substring)){
                used.add(substring); //Mark as explored
                backtrack(s, i + 1, used); //Move to next index
                used.remove(substring); //Backtrack if doesn't satisfy
            }
        }
    }
}