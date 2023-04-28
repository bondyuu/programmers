import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {
            int idx = map.get(callings[i]);

            players[idx] = players[idx - 1];
            players[idx - 1] = callings[i];

            map.put(players[idx],idx);
            map.put(players[idx-1],idx-1);
        }

        return players;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        System.out.println(Arrays.toString(sol.solution(players, callings)));
    }
}