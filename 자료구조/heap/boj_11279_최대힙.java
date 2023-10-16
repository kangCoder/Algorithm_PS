package 자료구조.heap;

import java.util.*;
import java.io.*;

public class boj_11279_최대힙 {

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int op = Integer.parseInt(br.readLine());
            if (op == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(op);
            }
        }
    }
}
