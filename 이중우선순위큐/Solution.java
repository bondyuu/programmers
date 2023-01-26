import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        List<Integer> list = new ArrayList<>();

        for (int j = 0; j < operations.length; j++) {
//            String[] arr = operations[j].split(" ");
            String action = operations[j].split(" ")[0];
            int num = Integer.parseInt(operations[j].split(" ")[1]);

            if (action.equals("I")) {
                if (list.size() == 0) {
                    list.add(num);
                } else if (list.size() == 1) {
                    if(num > list.get(0)) {
                        list.add(num);
                    } else {
                        list.add(0, num);
                    }
                } else {
                    if (num < list.get(0)) {
                        list.add(0, num);
                    } else if (num > list.get(list.size()-1)) {
                        list.add(num);
                    } else {
                        for (int i = 0; i < list.size() - 1; i++) {
                            if (num >= list.get(i) && num < list.get(i+1)){
                                list.add(i,num);
                            }
                        }
                    }

                }

                continue;
            }

            if (action.equals("D") && num == 1) {
                if (!list.isEmpty()) {
                    list.remove(list.size()-1);
                }
            }

            if (action.equals("D") && num == -1) {
                if (!list.isEmpty()) {
                    list.remove(0);
                }
            }

        }
        System.out.println(list);
        if (list.isEmpty()) {
            return answer;
        } else {
            answer[1] = list.get(0);
            answer[0] = list.get(list.size()-1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] operations = {"I 4", "I 3", "I 2", "I 1", "D 1", "D 1", "D -1", "D -1", "I 5", "I 6"};
        System.out.println(Arrays.toString(sol.solution(operations)));
    }
}