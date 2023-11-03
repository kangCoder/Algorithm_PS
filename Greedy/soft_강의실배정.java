package greedy;

import java.io.*;
import java.util.*;

public class soft_강의실배정 {

    static int N, ans = 0;
    static PriorityQueue<int[]> lectures;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        lectures = new PriorityQueue<>((a, b) -> a[1] - b[1]); //종료시간으로 오름차순 정렬하는 PQ.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.offer(new int[]{start, end});
        }

        int time = 0;
        while (!lectures.isEmpty()) {
            int[] cur = lectures.poll();
            //큐에서 꺼낸 강의의 시작 시간이 현재 시간보다 같거나 크면 강의를 추가
            if (cur[0] >= time) {
                ans++;
                time = cur[1]; //현재 시간을 꺼낸 강의의 종료 시간으로 갱신.
            }
        }

        System.out.println(ans);
    }
}