class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] robots = new Robot[n];
        for (int i = 0; i < n; i++) {
            robots[i] = new Robot(positions[i], healths[i], directions.charAt(i), i);
        }

        // Sort robots by their positions
        Arrays.sort(robots, Comparator.comparingInt(r -> r.position));

        Deque<Robot> stack = new ArrayDeque<>();

        for (Robot robot : robots) {
            if (robot.direction == 'R') {
                stack.push(robot);
            } else {
                while (!stack.isEmpty() && stack.peek().direction == 'R') {
                    Robot rightRobot = stack.peek();
                    if (rightRobot.health > robot.health) {
                        rightRobot.health -= 1;
                        robot.health = 0;
                        break;
                    } else if (rightRobot.health < robot.health) {
                        robot.health -= 1;
                        rightRobot.health = 0;
                        stack.pop();
                    } else {
                        rightRobot.health = 0;
                        robot.health = 0;
                        stack.pop();
                        break;
                    }
                }
                if (robot.health > 0) {
                    stack.push(robot);
                }
            }
        }

        List<Robot> survivors = new ArrayList<>(stack);
        survivors.sort(Comparator.comparingInt(r -> r.index));

        List<Integer> result = new ArrayList<>();
        for (Robot robot : survivors) {
            if (robot.health > 0) {
                result.add(robot.health);
            }
        }

        return result;
    }

    private static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }
}
