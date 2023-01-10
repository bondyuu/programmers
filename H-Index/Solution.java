import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for (int i = citations[citations.length-1]; i>=0; i--){
            int k = i;
            int len =Arrays.stream(citations).filter(a -> a>=k).toArray().length;
            if(len >=i){
                answer = i;
                break;
            }

        }



        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] citations = {3,0,6,1,5};
        System.out.println(sol.solution(citations));
    }
}