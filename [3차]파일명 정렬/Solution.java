import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];

        List<FileName> fnList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            FileName fn = new FileName(files[i]);
            fnList.add(fn);
        }

        Collections.sort(fnList);


        for (int i = 0; i < answer.length; i++) {
            answer[i] = fnList.get(i).toFile();
        }
        return answer;
    }



    public static class FileName implements Comparable<FileName> {
        private String head;
        private String number;
        private String tail;

        public FileName(String str) {
            String num = "";
            int idx = 0;
            for(int i = 0; i < str.toCharArray().length; i++) {
                char c = str.charAt(i);
                if (c < '0' || c > '9') {
                    idx++;
                } else{
                    break;
                }

            }
            for(int i = idx; i < str.toCharArray().length; i++) {
                char c = str.charAt(i);
                if (c >= '0' && c <= '9') {
                    num += c;

                } else {
                    break;
                }

            }
//            System.out.println(num);
            this.head = str.split(num)[0];
            this.number = num;
            if(str.split(num).length ==2){
                this.tail = str.split(num)[1];
            } else {
                this.tail = "";
            }

        }

        public String toFile() {
            return this.head+this.number+this.tail;
        }

        @Override
        public int compareTo(FileName o) {
            String head1 = this.head.toLowerCase();
            String head2 = o.head.toLowerCase();
            int num1 = Integer.parseInt(this.number);
            int num2 = Integer.parseInt(o.number);

            if (head1.compareTo(head2) == 0) {
                return num1 - num2;
            } else {
                return head1.compareTo(head2);
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] files = {"foo010bar020.zip","asd  45  .zip"};
        System.out.println(Arrays.toString(sol.solution(files)));
    }
}
