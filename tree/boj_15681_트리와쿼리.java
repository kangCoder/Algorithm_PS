package tree;

import java.util.*;
import java.io.*;

public class boj_15681_트리와쿼리 {

    static int N, R, Q;
    static List<ArrayList<Integer>> tree = new ArrayList<>();
    static int[] subTreeNodeCnt;

    static void findSubtreeNodes(int current, int parent) {
        subTreeNodeCnt[current] = 1;
        for (Integer node : tree.get(current)) {
            if (node != parent) {
                findSubtreeNodes(node, current);
                subTreeNodeCnt[current] += subTreeNodeCnt[node];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        subTreeNodeCnt = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        findSubtreeNodes(R, -1);

        for (int i = 0; i < Q; i++) {
            int U = Integer.parseInt(br.readLine());
            System.out.println(subTreeNodeCnt[U]);
        }
    }

}
