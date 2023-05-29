package graph;

import java.util.*;
import java.io.*;

public class soft_출퇴근길 {

    static int N, M;
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<ArrayList<Integer>> adjR;
    static boolean[] fromS, fromT, toS, toT;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        adjR = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
            adjR.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adjR.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        fromS = new boolean[N + 1];
        fromT = new boolean[N + 1];
        toS = new boolean[N + 1];
        toT = new boolean[N + 1];

        fromS[T] = true;
        dfs(S, adj, fromS);
        fromT[S] = true;
        dfs(T, adj, fromT);

        dfs(S, adjR, toS);
        dfs(T, adjR, toT);

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (fromS[i] && fromT[i] && toS[i] && toT[i]) {
                count++;
            }
        }

        System.out.println(count - 2);
    }

    public static void dfs(int now, ArrayList<ArrayList<Integer>> adj, boolean[] visit) {
        if (visit[now]) {
            return;
        }

        visit[now] = true;
        for (int i = 0; i < adj.get(now).size(); i++) {
            dfs(adj.get(now).get(i), adj, visit);
        }
    }
}