package greedy;

import java.util.*;
import java.io.*;

public class boj_2170_선긋기 {

    static int N, ans;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {start, end});
        }

        int[] first = pq.poll();
        int end = first[1];
        ans = first[1] - first[0];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            //1. 현재 시작점 < end 이고, 현재 끝점 > end 인 경우
            if (cur[0] < end && end < cur[1]) {
                ans += cur[1] - end;
                end = cur[1];
            } else if (cur[0] >= end) {
                //2. 현재 시작점 > end 인 경우
                ans += cur[1] - cur[0];
                end = cur[1];
            }

            System.out.println("현재 end=" + end);
        }

        System.out.println(ans);
    }
}