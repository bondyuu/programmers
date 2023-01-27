class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        for(int i = 0; i < stations.length; i++) {
            if (i == 0) {
                answer += getNum(0, stations[i]-w, 2 * w + 1);
            } else {
                answer += getNum(stations[i-1] + w, stations[i]-w, 2 * w + 1);
            }

            if (i == stations.length - 1) {
                answer += getNum(stations[i] + w, n + 1, 2 * w + 1);
            }

        }

        return answer;
    }

    public int getNum(int start, int end, int width) {
        System.out.println("start : " + start + ", end : " + end);
        int len = end - start - 1;
        if (len <= 0) {
            return 0;
        }
        int ans = 0;
        ans += len / width;
        if (len % width != 0) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] stations = {4, 11};
        System.out.println(sol.solution(11,stations,1));
    }
}