package 자료구조.priorityqueue;

import java.util.*;
import java.io.*;

public class boj_11286_절댓값힙 {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
        if (Math.abs(a) == Math.abs(b)) {
            return a - b;
        } else {
            return Math.abs(a) - Math.abs(b);
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(x);
            }
        }
    }

}
