class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        StringBuilder sRes = new StringBuilder();
        StringBuilder tRes = new StringBuilder();

        for(char c : s.toCharArray()){
            if(!stackS.isEmpty()){
                if(c == '#'){
                    stackS.pop();
                } else if(c != '#') {
                    stackS.push(c);
                }
            }else if(c != '#'){
                stackS.push(c);
            }
        }

        for(char c : t.toCharArray()){
            if(!stackT.isEmpty()){
                if(c == '#'){
                    stackT.pop();
                } else if(c != '#') {
                    stackT.push(c);
                }
            }else if(c != '#'){
                stackT.push(c);
            }
        }

        while(!stackS.isEmpty()){
            sRes.append(stackS.pop());
        }

        while(!stackT.isEmpty()){
            tRes.append(stackT.pop());
        }

        if(sRes.toString().equals(tRes.toString())){
            return true;
        }
        return false;
    }
}