import java.util.*;

class Solution {
    int[] emoticons;
    int[] discount = {10, 20, 30, 40};
    int[] arr;
    List<int[]> cases = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        this.emoticons = emoticons;

        dfs(0);

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < cases.size(); i++) {
            int[] cas = cases.get(i);
            int plus = 0;
            int price = 0;
            for (int[] user: users) {
                int temp = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (cas[j] >= user[0]) {
                        temp += emoticons[j] * (100-cas[j]) / 100;
                    }
                }
                System.out.println("user : " + Arrays.toString(user) + ", case : " + Arrays.toString(cas) + ", temp : " + temp);
                if (temp >= user[1]) {
                    plus++;
                } else {
                    price += temp;
                }
            }
            int[] tempArr = {plus, price};
            list.add(tempArr);
            System.out.println("plus : " + plus + ", price : " + price);
            System.out.println("-------------------------");
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]) {
                    return 1;
                } else if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return -1;
            }
        });

        return list.get(0);
    }

    public void dfs(int depth) {
        if (depth == emoticons.length) {
            cases.add(arr.clone());
        } else {
            for (int i = 0; i < discount.length; i++) {
                if (depth == 0) {
                    arr = new int[emoticons.length];
                }
                arr[depth] = discount[i];

                dfs(depth + 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol =  new Solution();

//        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
//        int[] emoticons = {1300, 1500, 1600, 4900};
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        System.out.println(Arrays.toString(sol.solution(users,emoticons)));
    }
}