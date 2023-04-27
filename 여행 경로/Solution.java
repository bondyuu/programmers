import java.util.*;

class Solution {
    private List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        int cnt = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                dfs(tickets[i][1], tickets[i][0] + " " + tickets[i][1],visited, tickets,cnt+2);
                visited[i] = false;
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.get(0).split(" ").length; i++) {
            answer[i] = list.get(0).split(" ")[i];
        }
        return answer;
    }

    public void dfs(String start, String temp, boolean[] visited, String[][] tickets, int cnt) {
        if (cnt == tickets.length+1) {
            list.add(temp);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], temp + " " + tickets[i][1], visited, tickets, cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(Arrays.toString(sol.solution(tickets)));
    }

}