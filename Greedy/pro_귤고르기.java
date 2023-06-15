package greedy;

import java.util.*;

public class pro_귤고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>(); //<크기, 개수>
        for (Integer t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet()) {
            list.add(map.get(i));
        }
        list.sort(Collections.reverseOrder()); //개수가 많은 순으로 내림차순

        int sum = 0;
        for (Integer t : list) {
            answer++;
            sum += t;
            if (sum >= k) {
                break;
            }
        }

        return answer;
    }
}