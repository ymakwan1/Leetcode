class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        if(digits == null || digits.isEmpty()){
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
        
        //generateCombinations(digits, map, 0, "", result);
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        for(char c : digits.toCharArray()){
            int qSize = queue.size();
            String letters = map.get(c);

            for(int i = 0; i < qSize; i++){
                String curr = queue.poll();
                for(char d : letters.toCharArray()){
                    queue.offer(curr+d);
                }
            }
        }

        result.addAll(queue);
        return result;
    }
}