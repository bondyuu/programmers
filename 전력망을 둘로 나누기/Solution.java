import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;

        for (int i = 0; i < wires.length; i++) {
            int temp = 0;
            boolean[] visited = new boolean[n+1];

            Deque<List<Integer>> dq = new ArrayDeque<>();
            List<Integer> list = new ArrayList<>();
            list.add(1);
            dq.add(list);
            temp++;
            visited[1] = true;

            while(!dq.isEmpty()) {
                List<Integer> popList = dq.pop();

                List<Integer> pushList = new ArrayList<>();
                for (int k : popList) {
                    for (int[] arr : wires) {
                        if (Arrays.equals(arr, wires[i])) {
                            continue;
                        }
                        if (arr[0] == k && !visited[arr[1]]) {
                            pushList.add(arr[1]);
                            visited[arr[1]] = true;
                            temp++;
                        }
                        if (arr[1] == k && !visited[arr[0]]) {
                            pushList.add(arr[0]);
                            visited[arr[0]] = true;
                            temp++;
                        }
                    }
                }

                if (!pushList.isEmpty()) {
                    dq.add(pushList);
                }
            }
            if (answer > Math.abs((temp)*2 -n)) {
                answer = Math.abs((temp)*2 -n);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] wires = {{1,2},{2,3},{3,4}};
        System.out.println(sol.solution(4,wires));

    }
}