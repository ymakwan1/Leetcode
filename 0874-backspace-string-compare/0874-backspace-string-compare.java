class Solution {
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();

        StringBuilder sRes = new StringBuilder();
        StringBuilder tRes = new StringBuilder();

        for(char c : s.toCharArray()){
            // if(!stackS.isEmpty()){
            //     if(c == '#'){
            //         stackS.pop();
            //     } else if(c != '#') {
            //         stackS.push(c);
            //     }
            // }else if(c != '#'){
            //     stackS.push(c);
            // }

            if(c == '#'){
                if(sRes.length() > 0){
                    sRes.deleteCharAt(sRes.length() - 1);
                }
            }else {
                    sRes.append(c);
            }
        }

        for(char c : t.toCharArray()){
            // if(!stackT.isEmpty()){
            //     if(c == '#'){
            //         stackT.pop();
            //     } else if(c != '#') {
            //         stackT.push(c);
            //     }
            // }else if(c != '#'){
            //     stackT.push(c);
            // }
            if(c == '#'){
                if(tRes.length() > 0){
                    tRes.deleteCharAt(tRes.length() - 1);
                } 
            }else {
                    tRes.append(c);
            }
        }

        // while(!stackS.isEmpty()){
        //     sRes.append(stackS.pop());
        // }

        // while(!stackT.isEmpty()){
        //     tRes.append(stackT.pop());
        // }

        // if(sRes.toString().equals(tRes.toString())){
        //     return true;
        // }
        // return false;
        return sRes.toString().compareTo(tRes.toString()) == 0;
    }
}