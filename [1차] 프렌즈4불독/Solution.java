import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = board.length-1; i >= 0; i--) {
            for(int j = 0; j < board[0].length(); j++) {
                list.get(j).add(String.valueOf(board[i].charAt(j)));
            }
        }

        while (true) {
            Set<String> set = new HashSet<>();
            for(int i = 0; i < m - 1; i++){
                for (int j = 0; j < n - 1; j++) {
                    if(!list.get(j).get(i).equals("-") && canRemove(new int[]{i,j},list)) {
                        set.add(i+" "+j);
                        set.add((i+1)+" "+j);
                        set.add(i+" "+(j+1));
                        set.add((i+1)+" "+(j+1));
                    }
                }
            }
            if (set.isEmpty()) {
                break;
            }
//            System.out.println(set);

            for(String a: set) {
                String[] k = a.split(" ");
                int r = Integer.parseInt(k[0]);
                int c = Integer.parseInt(k[1]);
                list.get(c).set(r,".");
                list.get(c).add("-");
            }
            for(int i = 0; i < list.size(); i++) {
                while (list.get(i).contains(".")) {
                    list.get(i).remove(".");
                }
            }
//            System.out.println(list);
            answer += set.size();
        }


        return answer;
    }

    public boolean canRemove(int[] point, List<List<String>> list) {
        int r = point[0];
        int c = point[1];
        return list.get(c).get(r).equals(list.get(c).get(r+1))
                && list.get(c).get(r).equals(list.get(c+1).get(r))
                && list.get(c).get(r).equals(list.get(c+1).get(r+1));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] board = {"TTTANT",
                          "RRFACC",
                          "RRRFCC",
                          "TRRRAA",
                          "TTMMMF",
                          "TMMTTJ"};
        System.out.println(sol.solution(6,6,board));
    }
}