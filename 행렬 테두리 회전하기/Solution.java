import java.util.Arrays;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] tbl = new int[rows][columns];

        for (int i = 0; i < rows; i ++) {
            for(int j = 0; j < columns; j++) {
                tbl[i][j] = i*columns + j+1;
            }
        }

        int idx = 0;
        for (int[] query: queries) {
            int min = rows * columns + 1;

            int[] start = {query[0]-1, query[1]-1}; //1,1
            int[] end = {query[2]-1, query[3]-1};   //4,3
            //arr  1,1 1,2 1,3 2,3 3,3 4,3 4,2 4,1 3,1 2,1

            int[][] arr = getArr(start, end);
//            for(int[] k : arr) {
//                System.out.println(Arrays.toString(k));
//            }


            int temp1 = 0;
            int temp2 = 0;
            for (int i = 0; i < arr.length; i++) {
                int r = arr[i][0];
                int c = arr[i][1];

                if(tbl[r][c] < min) {
                    min = tbl[r][c];
                }

                temp1 = tbl[r][c];

                if (i == 0) {
                    temp2 = tbl[r][c];
                    tbl[r][c] = tbl[arr[arr.length-1][0]][arr[arr.length-1][1]];

                    continue;
                }

                tbl[r][c] = temp2;
                temp2 = temp1;

            }

//            for(int[] a: tbl) {
//                System.out.println(Arrays.toString(a));
//            }
//            System.out.println("--------------------------------");
            answer[idx] = min;
            idx++;
        }

        return answer;
    }

    public int[][] getArr(int[] start, int[] end) {
        int wid = end[0] - start[0] + 1;
        int len = end[1] - start[1] + 1;
        //2,2 ,5,5
        int[][] arr = new int[wid*len - (wid-2)*(len-2)][2];
        arr[0][0] = start[0];
        arr[0][1] = start[1];

        for (int i = 1; i < arr.length; i++) {

            if (i < len) {
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][1] + 1;
            } else if (i < len + wid -1) {
                arr[i][0] = arr[i-1][0] + 1;
                arr[i][1] = arr[i-1][1];
            } else if (i < 2*len + wid -2) {
                arr[i][0] = arr[i-1][0];
                arr[i][1] = arr[i-1][1] - 1;
            } else {
                arr[i][0] = arr[i-1][0] - 1;
                arr[i][1] = arr[i-1][1];
            }

        }



        return arr;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        System.out.println(Arrays.toString(sol.solution(6, 6, queries)));
    }
}