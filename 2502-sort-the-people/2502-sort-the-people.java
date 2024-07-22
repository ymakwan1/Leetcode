class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        List<int[]> people = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            people.add(new int[]{heights[i], i});
        }
        
        Collections.sort(people, (a, b) -> b[0] - a[0]);
        
        String[] sortedNames = new String[n];
        for (int i = 0; i < n; i++) {
            sortedNames[i] = names[people.get(i)[1]];
        }
        
        return sortedNames;
    }
}
