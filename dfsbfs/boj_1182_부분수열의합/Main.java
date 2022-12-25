package dfsbfs.boj_1182_부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, S;
    public static int[] arr;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //배열의 크기
        S = Integer.parseInt(st.nextToken()); //합이되는 정수

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ans = 0;
        dfs(0, 0);
        if (S == 0) {
            System.out.println(ans - 1);
        } else {
            System.out.println(ans);
        }
    }

    public static void dfs(int depth, int sum) {
        //배열의 끝까지 탐색한 경우
        if (depth == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }

}
