package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11725_트리의부모찾기 {

    public static List<List<Integer>> tree;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        visited = new boolean[N];
        int[] parents = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (Integer node : tree.get(n)) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    parents[node] = n;
                }
            }
        }

        for (int i = 1; i < parents.length; i++) {
            System.out.println(parents[i] + 1);
        }
    }

}
