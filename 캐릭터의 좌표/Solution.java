class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (String input: keyinput) {
            int idx = -1;
            switch (input) {
                case "right" -> idx = 0;
                case "left" -> idx = 1;
                case "up" -> idx = 2;
                case "down" -> idx = 3;
            }

            if (Math.abs(answer[0] + dx[idx]) <= (board[0]-1)/2 && Math.abs(answer[1] + dy[idx]) <= (board[1]-1)/2) {
                answer[0] += dx[idx];
                answer[1] += dy[idx];
            }

        }
        return answer;
    }
}