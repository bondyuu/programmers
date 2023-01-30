import java.math.BigInteger;

class Solution {
    public BigInteger solution(int balls, int share) {

        BigInteger answer = getMul(balls, balls - share + 1).divide(getMul(share, 1));

        return answer;
    }

    public BigInteger getMul(int from, int to) {
        BigInteger ans = new BigInteger("1");
        for (int i = from; i >= to; i--){
            ans = ans.multiply(new BigInteger(String.valueOf(i)));
        }
        return ans;
    }
}