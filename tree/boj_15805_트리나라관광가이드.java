package tree;

import java.util.*;
import java.io.*;

public class boj_15805_트리나라관광가이드 {

    static final int MAX = 200_000;

    static int N;
    static int[] path, parent;
    static Set<Integer> tree = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        path = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[MAX];
        parent[path[0]] = -1; //root는 부모가 없다.
        tree.add(path[0]);
        for (int i = 1; i < path.length; i++) {
            //아직 방문한 적이 없는 노드 -> 바로 전 노드의 자식
            if (!tree.contains(path[i])) {
                parent[path[i]] = path[i - 1];
                tree.add(path[i]);
            }
        }

        System.out.println(tree.size());
        for (int i = 0; i < tree.size(); i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

}
