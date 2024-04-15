class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //Add freq to hashmap
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Entries to list
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());

        //Sort in descending order
        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>> (){
            @Override
            public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
                return e2.getValue().compareTo(e1.getValue());
            }
        });

        //Build the string from list
        StringBuilder str = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : entryList) {
            char c = entry.getKey();
            int count = entry.getValue();

            for(int i = 0;  i < count; i++){
                str.append(c);
            }
        }

        return str.toString();
    }
}