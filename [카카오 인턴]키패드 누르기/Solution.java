import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] position = new int[2][2];
        position[0][0] = 4;
        position[0][1] = 1;
        position[1][0] = 4;
        position[1][1] = 3;

        for(int num: numbers) {
//            for (int[] k: position) {
//                System.out.println(num + ":" + Arrays.toString(k));
//            }
            if (num % 3 == 1) {
                answer += "L";
                moveWithFingerAndDial("L",num,position);
                continue;
            }

            if (num % 3 == 0 && num!= 0) {
                answer += "R";
                moveWithFingerAndDial("R",num,position);
                continue;
            }

            int lenFromLeft = getDistance(position[0], num);
            int lenFromRight = getDistance(position[1], num);

            if (lenFromLeft == lenFromRight) {
                String move = String.valueOf(hand.charAt(0)).toUpperCase();
                answer += move;

                if (move.equals("R")) {
                    moveWithFingerAndDial("R",num,position);
                } else {
                    moveWithFingerAndDial("L",num,position);
                }

            } else if (lenFromLeft > lenFromRight) {
                answer += "R";
                moveWithFingerAndDial("R",num,position);
            } else {
                answer += "L";
                moveWithFingerAndDial("L",num,position);
            }

        }
//        for (int[] k: position) {
//            System.out.println(Arrays.toString(k));
//        }
        return answer;
    }

    public int getDistance(int[] position, int num) {
        int[] to = new int[2];
        if (num ==0){
            to[0] = 4;
            to[1] = 2;
        } else {
            to[0] = num /3 + 1;
            to[1] = 2;
        }

        int diffX = Math.abs(to[0] - position[0]);
        int diffY = Math.abs(to[1] - position[1]);

        return diffX + diffY;
    }

    public void moveWithFingerAndDial(String finger, int dial, int[][] position) {
        int fin = finger.equals("R")?1:0;
        if (dial % 3 == 0) {
            if (dial == 0) {
                position[fin][0] = 4;
                position[fin][1] = 2;
            } else {
                position[fin][0] = dial / 3;
                position[fin][1] = 3;
            }

        } else {
            position[fin][0] = dial / 3 + 1;
            position[fin][1] = dial % 3;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(sol.solution(numbers,"right"));
    }
}