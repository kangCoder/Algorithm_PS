package greedy;

import java.util.*;
import java.io.*;

public class boj_11000_강의실배정 {

    static int N;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        //시작 시간을 기준으로 정렬
        pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {start, end});
        }

        PriorityQueue<Integer> answer = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            //현재 시작 시간이 이전 종료 시간보다 같거나 크면 같은 강의실 사용 가능.
            if (!answer.isEmpty() && cur[0] >= answer.peek()) {
                answer.poll();
            }
            //그게 아니라면 강의실을 추가해야 함.
            answer.offer(cur[1]);
        }

        System.out.println(answer.size());
    }
}