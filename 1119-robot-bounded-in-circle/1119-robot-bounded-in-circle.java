class Solution {
    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int direction = 0;
        int dx = 0;
        int dy = 1;

        for(char ins : instructions.toCharArray()){
            if(ins == 'G'){
                x += dx;
                y += dy;
            } else if(ins == 'L'){
                int temp = dx;
                dx = -dy;
                dy = temp;
            } else if(ins == 'R'){
                int temp = dx;
                dx = dy;
                dy = -temp;
            }
        }
        return (x == 0 && y == 0) || (dx != 0 || dy != 1);
    }
}