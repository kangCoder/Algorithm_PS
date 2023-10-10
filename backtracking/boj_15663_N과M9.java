package backtracking;

import java.util.*;
import java.io.*;

public class boj_15663_N과M9 {

    static int N, M;
    static int[] arr, output;
    static boolean[] isUsed;
    static Set<String> set = new LinkedHashSet<>();

    static void dfs(int cur) {
        if (cur == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : output) {
                sb.append(i).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                output[cur] = arr[i];
                dfs(cur + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        isUsed = new boolean[N];
        output = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        set.forEach(System.out::println);
    }
}
