package greedy;

import java.util.*;

public class pro_호텔대실 {

    public int solution(String[][] book_time) {
        //시작 시간을 기준으로 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (String[] time : book_time) {
            int start = Integer.parseInt(time[0].replace(":", ""));
            int end = Integer.parseInt(time[1].replace(":", ""));

            //넣을 때 종료 시간 + 10분으로 넣는다.
            int endPlusTen = end + 10;
            if (endPlusTen % 100 >= 60) {
                endPlusTen = ((endPlusTen / 100 + 1) * 100) + (endPlusTen % 100 - 60);
            }
            pq.offer(new int[]{start, endPlusTen});
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            //만약 현재 시작 시각이 이전 종료 시각보다 10분 뒤라면 그 객실을 그대로 쓸 수 있다.
            //현재 시작 시각 >= 이전 종료 시각 + 10분이면 객실을 더 추가 안해도 됨.
            if (!room.isEmpty() && cur[0] >= room.peek()) {
                room.poll();
            }

            room.offer(cur[1]);
        }

        return room.size();
    }
}