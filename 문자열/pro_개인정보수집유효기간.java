package 문자열;

import java.util.*;

public class pro_개인정보수집유효기간 {

    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> ans = new ArrayList<>();

        String[] todays = today.split("\\.");
        System.out.println(todays.length);
        int toYear = Integer.parseInt(todays[0]);
        int toMonth = Integer.parseInt(todays[1]);
        int toDay = Integer.parseInt(todays[2]);
        int todayInt = toYear * 12 * 28 + toMonth * 28 + toDay;

        HashMap<String, Integer> termMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            termMap.put(term[0], Integer.parseInt(term[1]));
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");

            String deadLine = privacy[0].replace(".", " ");

            String[] date = deadLine.split(" ");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day = Integer.parseInt(date[2]);

            int term = termMap.get(privacy[1]);
            month += term;

            int result = year * 12 * 28 + month * 28 + day;

            System.out.println(todayInt + ", " + result);
            if (todayInt >= result) {
                ans.add(i + 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

}
