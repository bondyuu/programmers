class Solution2 {
    public int[] solution(int n, int s) {
        int m = s/n;
        int r = s%n;

        if(m == 0){
            return new int[]{-1};
        }

        int[] answer = new int[n];

        for(int i = answer.length-1; i >= 0;i--){
            answer[i] = m;

            if(r > 0){
                answer[i]++;
                r--;
            }
            
        }

        return answer;
    }

}