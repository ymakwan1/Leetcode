class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> indexStack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if (c[i] == '(') {
                indexStack.push(i);
            }
            else if (c[i] == ')'){
                if (indexStack.isEmpty()) {
                    set.add(i);
                } else {
                    indexStack.pop();
                }
            }
        }
        while (!indexStack.isEmpty()) {
            set.add(indexStack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                stringBuilder.append(s.charAt(i));
            }
        }

        return stringBuilder.toString();
    }
}