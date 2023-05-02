package 자료구조.priorityqueue;

import java.util.*;

public class pro_야근지수 {

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer work : works) {
            pq.add(work);
        }

        if (pq.stream().mapToInt(Integer::intValue).sum() <= n) {
            return 0;
        }

        while (n > 0) {
            int tmp = pq.poll();
            tmp--;
            pq.add(tmp);
            n--;
        }

        while (!pq.isEmpty()) {
            int w = pq.poll();
            answer += w * w;
        }

        return answer;
    }

}
