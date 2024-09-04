class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Directions north, east, south, west
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, dir = 0; // Starting at (0, 0) facing north
        int maxDist = 0;

        // set for quick lookup
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }

        // Process each command
        for (int command : commands) {
            if (command == -2) {
                // Turn left: counterclockwise rotation
                dir = (dir + 3) % 4;
            } else if (command == -1) {
                // Turn right: clockwise rotation
                dir = (dir + 1) % 4;
            } else {
                // Move forward steps in the current direction
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[dir][0];
                    int nextY = y + directions[dir][1];
                    // Check if the next position is an obstacle
                    if (!obstacleSet.contains(nextX + "," + nextY)) {
                        x = nextX;
                        y = nextY;
                        maxDist = Math.max(maxDist, x * x + y * y);
                    } else {
                        // Stop moving if we encounter an obstacle
                        break;
                    }
                }
            }
        }

        return maxDist;
    }
}
