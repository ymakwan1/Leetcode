class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if (map.containsValue(ch)) {
                stack.push(ch);
            } else if (map.containsKey(ch)){
                if (stack.isEmpty() || map.get(ch) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}