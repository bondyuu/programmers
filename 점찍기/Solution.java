class Solution {
    public static long solution(int k, int d) {
        long answer = 0;

        int i = 0;
        while (i <= d) {
            double limit = getDistanceLimit(d, i);

            answer += (int) limit / k +1;

            i += k;
        }



        return answer;
    }

    public static double getDistanceLimit(int d, int i) {
        return Math.sqrt(Math.pow(d,2) -Math.pow(i,2));
    }

    public static void main(String[] args) {

        System.out.println(solution(2,4));
    }
}