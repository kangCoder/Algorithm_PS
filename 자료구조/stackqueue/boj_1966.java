package 자료구조.stackqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            Queue<Pair> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Pair(j, priority));
            }

            int result = 1;
            while (true) {
                boolean flag = true;
                Pair value = queue.poll();
                for (Pair q : queue) {
                    if (value.priority < q.priority) {
                        queue.offer(value);
                        flag = false;
                        break;
                    }
                }

                if (!flag) {
                    continue;
                }
                result++;

                if (value.index == M && flag) {
                    break;
                }
            }

            bw.write(result - 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Pair {
        int index;
        int priority;

        public Pair(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
