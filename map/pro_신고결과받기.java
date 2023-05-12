package map;

import java.util.*;

public class pro_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> listMap = new HashMap<>(); //<id, 그에 해당하는 인덱스>
        Map<String, HashSet<String>> reportMap = new HashMap<>(); //<신고받은 사람, 신고한 사람들>

        for (int i = 0; i < id_list.length; i++) {
            listMap.put(id_list[i], i);
        }

        for (int i = 0; i < report.length; i++) {
            String[] user = report[i].split(" ");

            if (reportMap.get(user[1]) == null) {
                reportMap.put(user[1], new HashSet<>());

            }

            HashSet<String> set = reportMap.get(user[1]);
            set.add(user[0]);
            reportMap.put(user[1], set);
        }

        for (int i = 0; i < id_list.length; i++) {
            Set<String> set = reportMap.get(id_list[i]); //해당 사람을 신고한 사람들의 set
            //신고를 k번 이상 당했다면 정지
            if (set != null && set.size() >= k) {
                Iterator<String> it = set.iterator();
                while (it.hasNext()) {
                    String id = it.next();
                    answer[listMap.get(id)]++;
                }
            }
        }

        return answer;
    }
}