import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] used = new boolean[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        Queue<List<Integer>> queue = new LinkedList<>();

        List<Integer> a = new ArrayList<>();
        for (int[] arr : edge) {
            if (arr[0] == 1 || arr[1] == 1) {
                int k = arr[0] == 1 ? arr[1] : arr[0];
                if (!used[k-1]) {
                    a.add(k);
                    used[k-1] = true;
                }

            }
        }
        queue.offer(a);
        map.put(1, a);
        used[0] = true;

        int i = 1;
        while (!queue.isEmpty()) {
            i++;
            List<Integer> list = new ArrayList<>();
            List<Integer> last = queue.poll();
            for (int k: last) {
                for (int[] arr: edge) {
                    if (arr[0] == k || arr[1] == k) {
                        int p = k == arr[0] ? arr[1] : arr[0];
                        if (!used[p-1]) {
                            list.add(p);
                            used[p-1] = true;
                        }
                    }
                }
            }
            if (!list.isEmpty()) {
                queue.offer(list);
                map.put(i, list);
            }
        }
        answer = map.get(i-1).size();

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(sol.solution(6, edge));
    }
}