class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        
        generateCombinations(digits, map, 0, "", result);

        return result;
    }

    public void generateCombinations(String digits, HashMap<Character, String> map, int index, String curr, List<String> result){
        if(index == digits.length()){
            result.add(curr);
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for(int i = 0; i < letters.length(); i++){
            char letter = letters.charAt(i);
            generateCombinations(digits, map, index+1,curr+letter,result);
        }
    }
}