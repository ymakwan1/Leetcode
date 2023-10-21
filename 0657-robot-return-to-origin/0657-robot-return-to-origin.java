class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for(char ins : moves.toCharArray()){
            if(ins == 'U'){
                y += 1;
            } else if(ins == 'D'){
                y -= 1;
            } else if(ins == 'R'){
                x += 1;
            } else if(ins == 'L'){
                x -= 1;
            }
        }
        return (x == 0 && y == 0);
    }
}