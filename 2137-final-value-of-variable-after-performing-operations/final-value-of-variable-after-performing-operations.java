class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for (String string : operations) {
            if (string.equals("--X")) {
                x-=1;
            } 
            else if(string.equals("X--")){
                x-=1;
            }
            else if(string.equals("X++")){
                x+=1;
            }
            else{
                x+=1;
            }
        }
        return x;
    }
}