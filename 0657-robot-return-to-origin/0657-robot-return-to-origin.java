class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for(char ins : moves.toCharArray()){
            if(ins == 'U'){
                //x += 0;
                y += 1;
            } else if(ins == 'D'){
                //x += 0;
                y -= 1;
            } else if(ins == 'R'){
                x += 1;
                //y += 0;
            } else if(ins == 'L'){
                x -= 1;
                //y += 0;
            }
        }
        return (x == 0 && y == 0);
    }
}