class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());

        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c == '(') {
                // Start of a new nested group
                stack.push(new HashMap<>());
                i++;
            } else if (c == ')') {
                // End of a nested group
                i++;
                // Parse the number following the closing parenthesis
                int start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                // Pop the map of the nested group and multiply its counts
                Map<String, Integer> top = stack.pop();
                Map<String, Integer> peek = stack.peek();
                for (String key : top.keySet()) {
                    peek.put(key, peek.getOrDefault(key, 0) + top.get(key) * multiplicity);
                }
            } else {
                // Parse an element name
                int start = i;
                i++; // Move past the first character of the element name
                while (i < formula.length() && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                // Parse the number following the element name
                start = i;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = start < i ? Integer.parseInt(formula.substring(start, i)) : 1;
                // Update the count of the element in the current level map
                Map<String, Integer> peek = stack.peek();
                peek.put(name, peek.getOrDefault(name, 0) + multiplicity);
            }
        }

        // The final counts of atoms are in the map at the bottom of the stack
        Map<String, Integer> counts = stack.pop();
        // Sort the elements alphabetically and build the result string
        StringBuilder result = new StringBuilder();
        for (String key : new TreeSet<>(counts.keySet())) {
            result.append(key);
            int count = counts.get(key);
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }
}
