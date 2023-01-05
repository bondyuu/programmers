import java.util.Arrays;

class Solution {
    public static int solution(int storey) {
        int answer = 0;
        String[] arr = String.valueOf(storey).split("");

        for (int i = arr.length - 1; i > 0; i--){
            if ((Integer.parseInt(arr[i-1])>=5 && Integer.parseInt(arr[i]) == 5) || (Integer.parseInt(arr[i]) > 5 && Integer.parseInt(arr[i]) <=10 )) {
                arr[i-1] = String.valueOf(Integer.parseInt(arr[i-1]) + 1);

            }
        }
        if(Integer.parseInt(arr[0])>5 && Integer.parseInt(arr[0]) < 10){
            arr[0] = String.valueOf(Integer.parseInt(arr[0]) +10);
        }
        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].equals("10")) {
                arr[i] = "0";
            }
            if(Integer.parseInt(arr[i]) > 5) {
                answer += 10 - Integer.parseInt(arr[i]);
            } else {
                answer += Integer.parseInt(arr[i]);
            }
        }

        answer += Integer.parseInt(arr[0]) /10;
        if (Integer.parseInt(arr[0]) %10 > 5 ) {
            answer += 10 - (Integer.parseInt(arr[0]) %10);
        } else {
            answer += Integer.parseInt(arr[0]) %10;
        }

        return answer;
    }



    public static void main(String[] args) {
        int a = 199; //1 10 9
        System.out.println(solution(a));

        int b = 2554; //3 6 5 4
        System.out.println(solution(b));

        b = 16;  // 2 6
        System.out.println(solution(b));

        b = 1234; //1 2 3 4
        System.out.println(solution(b));

        b = 693840; //17 9 4 8 4 0
        System.out.println(solution(b));

        b = 345992; // 3 5 6 10 9 2
        System.out.println(solution(b));

        b = 689234; //17 9 9 2 3 4
        System.out.println(solution(b));

        b = 23048629; // 2 3 0 5 9 6 3 9
        System.out.println(solution(b));

        b = 9769049; // 3 5 6 10 9 2
        System.out.println(solution(b));

        b = 98240598; // 10 8 2 4 1 6 10 8
        System.out.println(solution(b));
    }
}