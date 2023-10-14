class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        
        String[] pathParts = path.split("/");

        for(String part : pathParts){
            if(part.equals("") || part.equals(".")){
                continue;
            } else if(part.equals("..") && !stack.isEmpty()){
                stack.pop();
            } else if(!part.equals("..") && !part.equals(".")){
                stack.push(part);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        for(String s : stack){
            if(!stack.equals(""))
                result.append("/"+s);
        }
        return result.toString();
    }
}