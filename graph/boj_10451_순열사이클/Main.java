package graph.boj_10451_순열사이클;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static LinkedList<Integer>[] list;
    static boolean[] visited;
    static boolean isCycle;

    public static void checkCycleByDFS(int start) {
        visited[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int next = list[start].get(i);
            if (!visited[next]) {
                checkCycleByDFS(next);
            } else {
                isCycle = true;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            list = new LinkedList[N + 1];
            for (int j = 1; j <= N; j++) {
                list[j] = new LinkedList<>();
            }

            for (int j = 1; j <= N; j++) {
                list[j].add(arr[j - 1]);
            }

            int cycle = 0;
            visited = new boolean[N + 1];
            for (int j = 1; j <= N; j++) {
                isCycle = false;
                if(!visited[j]) {
                    checkCycleByDFS(j);
                    if(isCycle)
                        cycle++;
                }
            }

            System.out.println(cycle);
        }
    }
}
