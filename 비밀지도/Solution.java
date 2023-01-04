import java.util.Arrays;

class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String[] str1 = getBinaryString(arr1[i], n).split("");
            String[] str2 = getBinaryString(arr2[i], n).split("");
            String ans = "";
            for (int j = 0; j < n; j++){

                if (str1[j].equals("1") || str2[j].equals("1")){
                    ans += "#";
                } else {
                    ans += " ";
                }
            }
            answer[i] = ans;
        }

        return answer;
    }

    public static String getBinaryString(int k, int n) {
        String ans = Integer.toBinaryString(k);

        if(ans.length()<n){
            String str = "0".repeat(n-ans.length());
            ans = str.concat(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        System.out.println(solution(n,arr1,arr2)[0]);
        System.out.println(solution(n,arr1,arr2)[1]);
        System.out.println(solution(n,arr1,arr2)[2]);
        System.out.println(solution(n,arr1,arr2)[3]);
        System.out.println(solution(n,arr1,arr2)[4]);
//        System.out.println(Solution.getBinaryString(9));
    }
}

