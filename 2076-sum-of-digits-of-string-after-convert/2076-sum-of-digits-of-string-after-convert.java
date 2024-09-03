class Solution {
    public int getLucky(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int number = ch - 'a' + 1;
            map.put(ch, number);
        }

        StringBuilder sb = new StringBuilder();
        for(char st : s.toCharArray()){
            sb.append(map.get(st));
        }

        String curr = sb.toString();
        for(int i = 0; i < k; i++){
            int sum = 0;
            for(char c : curr.toCharArray()){
                sum += c - '0';
            }
            curr = String.valueOf(sum);
        }

        return Integer.parseInt(curr);
    }
}