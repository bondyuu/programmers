import java.util.Arrays;
import java.util.Comparator;


class Solution {
    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[col-1] > o2[col-1]){
                    return 1;
                } else if (o1[col-1] == o2[col-1]) {
                    if(o1[0]<o2[0]){
                        return 1;
                    }
                }
                return -1;
            }
        });

        for(int[] arr: data){
            System.out.println(Arrays.toString(arr));
        }

        int[] SI = new int[row_end - row_begin +1];
        for(int i = row_begin-1; i < row_end; i++){
            for(int k: data[i]){
                SI[i- row_begin + 1] += k % (i+1);
            }
        }

        for(int k : SI){
            answer = answer ^ k;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        System.out.println(solution(data, 2, 2, 3));
    }

}