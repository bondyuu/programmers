import java.util.Arrays;

class Solution {
    int[][] board;
    public int solution(int[][] board) {
        int n = board.length;
        int answer = n*n;
        this.board = new int[board.length + 2][board.length + 2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                this.board[i+1][j+1] = board[i][j];
            }
        }

        for (int i = 1; i < this.board.length - 1; i++) {
            for (int j = 1; j < this.board.length - 1; j++) {
                if (isDanger(i,j)) {
                    answer--;
                }
            }
        }
        return answer;
    }

    public boolean isDanger(int i, int j) {
        int[][] arr = this.board;
        return arr[i-1][j-1] == 1 || arr[i-1][j] == 1 || arr[i-1][j+1] == 1 || arr[i][j-1] == 1 ||arr[i][j] == 1
                || arr[i][j+1] == 1 || arr[i+1][j-1] == 1 || arr[i+1][j] == 1 || arr[i+1][j+1] == 1;
    }
}