package graph;

import java.util.*;
import java.io.*;

public class boj_15723_n단논법 {

    static List<Integer>[] graph;

    static boolean isTrue(int a, int b) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(a);
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph[cur].size(); i++) {
                int nxt = graph[cur].get(i);
                if (nxt == b) {
                    return true;
                } else {
                    q.offer(nxt);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new List[30];
        for (int i = 0; i < 30; i++) {
            graph[i] = new ArrayList<>();
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] premise = br.readLine().split(" ");
            char a = premise[0].charAt(0);
            char b = premise[2].charAt(0);
            graph[a - 97].add((int) (b - 97));
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] conclusion = br.readLine().split(" ");
            char a = conclusion[0].charAt(0);
            char b = conclusion[2].charAt(0);
            if (isTrue(a - 97, b - 97)) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }

    }
}
