package 자료구조.stackqueue;

import java.util.*;
import java.io.*;

public class boj_2164_카드2 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int idx = 0;
        while (q.size() > 1) {
            int c = q.poll();

            if (idx % 2 == 1) {
                q.offer(c);
            }
            idx++;
        }

        System.out.println(q.peek());
    }
}