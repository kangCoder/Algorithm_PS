package 삼성SW역량준비.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크 {

    static int N, ans, starts, links;
    static int[][] S;
    static boolean[] visited;

    public static int calculateDiff() {
        starts = 0;
        links = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    starts += S[i][j];
                    starts += S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    links += S[i][j];
                    links += S[j][i];
                }
            }
        }

        return Math.abs(starts - links);
    }

    public static void solution(int cnt, int start) {
        if (cnt == N / 2) {
            ans = Math.min(ans, calculateDiff());
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                solution(cnt + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        ans = Integer.MAX_VALUE;

        solution(0, 0);
        System.out.println(ans);
    }

}
