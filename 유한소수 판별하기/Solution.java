class Solution {
    public int solution(int a, int b) {
        int answer = 2;

        int gcd = getGCD(a,b);

        b = b / gcd;

        do {
            if (b % 2 == 0) {
                b /= 2;
            }

            if (b % 5 == 0) {
                b /= 5;
            }

        } while (b % 2 == 0 || b % 5 == 0);

        if (b == 1) {
            return 1;
        }

        return answer;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return getGCD(b, a % b);
        }
    }

    public static void main(String[] args) {

    }
}