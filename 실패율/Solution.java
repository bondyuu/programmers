import java.util.*;

class Solution {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[][] arr = new int[N][3];
        for(int i = 0; i < N; i++) {
            arr[i][2] = i + 1;
        }

        for(int n: stages){
            if (n<=N){
                for (int i = 0; i < n; i++){
                    arr[i][0] += 1;

                }
                arr[n-1][1] += 1;
            } else {
                for (int i = 0; i < N; i++){
                    arr[i][0] += 1;
                }
            }

        }
//        for(int[] a: arr){
//            System.out.println(Arrays.toString(a));
//        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                double one = o1[0] == 0? 0 : Double.valueOf((double) o1[1] / o1[0]);
                double two = o2[0] == 0? 0 :Double.valueOf((double) o2[1] / o2[0]);
                if(one < two) {
                    return 1;
                }
                else if(one == two) {
                    if(o1[2] > o2[2]) {
                        return 1;
                    }
                }
                return -1;
            }
        });

//        for(int[] k : arr){
//            System.out.println(k[2] + ":" + Double.valueOf((double) k[1] / k[0]));
//        }

        for (int i = 0; i < N; i++){
            answer[i] = arr[i][2];
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = solution(N,stages);
        for(int i: answer){
            System.out.println(i);
        }

    }

}