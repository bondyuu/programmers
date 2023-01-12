import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, List<String>> map = getRecordPerCar(records);

        List<String> numList = getSortedNumList(map);

        int[] answer = new int[map.size()];

        int i =0;
        for(String num: numList) {
            int totalTime = getTotalTime(map.get(num));
            System.out.println(totalTime);
            int fee = getFee(totalTime, fees);
            answer[i] = fee;
            i++;
        }

        return answer;
    }

    public Map<String, List<String>> getRecordPerCar(String[] records){
        Map<String, List<String>> map = new HashMap<>();

        for(String record: records) {
            String[] arr = record.split(" ");

            if (map.containsKey(arr[1])) {
                map.get(arr[1]).add(arr[0] + " " + arr[2]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(arr[0] + " " + arr[2]);
                map.put(arr[1], list);
            }
        }
        return map;
    }

    public List<String> getSortedNumList(Map<String, List<String>> map) {
        List<String> numList = new ArrayList<>(map.keySet());
        Collections.sort(numList);
        return numList;
    }

    public int getTotalTime(List<String> record) {
        int[] total = new int[2];
        if (record.size() % 2 ==0) {
            for(int i = 1; i < record.size(); i += 2) {
                String[] outArr = record.get(i).split(" ")[0].split(":");
                String[] inArr = record.get(i-1).split(" ")[0].split(":");
                int[] out = {Integer.parseInt(outArr[0]),Integer.parseInt(outArr[1])};
                int[] in = {Integer.parseInt(inArr[0]),Integer.parseInt(inArr[1])};

                total[0] += out[0] - in[0];
                total[1] += out[1] - in[1];
            }

        } else {
            for(int i = 1; i < record.size()-1; i += 2) {
                String[] outArr = record.get(i).split(" ")[0].split(":");
                String[] inArr = record.get(i-1).split(" ")[0].split(":");
                int[] out = {Integer.parseInt(outArr[0]),Integer.parseInt(outArr[1])};
                int[] in = {Integer.parseInt(inArr[0]),Integer.parseInt(inArr[1])};

                total[0] += out[0] - in[0];
                total[1] += out[1] - in[1];
            }

            String[] lastInArr = record.get(record.size()-1).split(" ")[0].split(":");
            int[] lastIn = {Integer.parseInt(lastInArr[0]),Integer.parseInt(lastInArr[1])};
            total[0] += 23 - lastIn[0];
            total[1] += 59 - lastIn[1];

        }


        return total[0] *60 + total[1];
    }

    public int getFee(int time, int[] fees) {
        if (time <= fees[0]) {
            return fees[1];
        }

        int chk = (time - fees[0]) % fees[2] == 0? (time - fees[0]) / fees[2] :(time - fees[0]) / fees[2] +1;
        return fees[1] + fees[3] * chk;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        System.out.println(Arrays.toString(sol.solution(fees,records)));
    }
}
