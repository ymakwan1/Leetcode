class Solution {
    public boolean backspaceCompare(String s, String t) {

        StringBuilder sRes = new StringBuilder();
        StringBuilder tRes = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == '#'){
                if(sRes.length() > 0){
                    sRes.deleteCharAt(sRes.length() - 1);
                }
            }else{
                sRes.append(c);
            }
        }

        for(char c : t.toCharArray()){
            if(c == '#'){
                if(tRes.length() > 0){
                    tRes.deleteCharAt(tRes.length() - 1);
                } 
            }else{
                tRes.append(c);
            }
        }
        return sRes.toString().equals(tRes.toString());
    }
}