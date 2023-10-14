class Solution {
    public String convert(String s, int numRows) {
        if(s.length() == numRows || numRows == 1){
            return s;
        }

        List<StringBuilder> zigzag = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            zigzag.add(new StringBuilder(""));
        }

        int j = 0;
        boolean down = true;
        int current = 0;
        while(j < s.length()){
            if(down){
                zigzag.get(current).append(s.charAt(j));
                current++;
                if(current >= numRows){
                    down = false;
                    current -=2;
                }
            } else {
                zigzag.get(current).append(s.charAt(j));
                current--;
                if(current < 0){
                    down = true;
                    current=1;
                }
            }
            j++;
        }

        StringBuilder st = new StringBuilder();
        for(StringBuilder sa : zigzag){
            st.append(sa);
        }

        return st.toString();
    }
}