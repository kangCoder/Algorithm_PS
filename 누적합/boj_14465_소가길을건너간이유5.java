package 누적합;

import java.io.*;
import java.util.*;

public class boj_14465_소가길을건너간이유5 {

    static int N, K, B, ans;
    static boolean[] crosswalk;
    static int[] pSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        crosswalk = new boolean[N + 1];
        for (int i = 0; i < B; i++) {
            crosswalk[Integer.parseInt(br.readLine())] = true;
        }

        int cnt = 0;
        for (int i = 1; i <= K; i++) {
            if (crosswalk[i]) {
                cnt++;
            }
        }

        pSum = new int[N + 1];
        pSum[K] = cnt; //K번째 횡단보도까지의 망가진 개수
        ans = cnt;
        for (int i = K + 1; i <= N; i++) {
            int tmp = pSum[i - 1];
            if (crosswalk[i]) {
                tmp++;
            }
            if (crosswalk[i - K]) {
                tmp--;
            }

            pSum[i] = tmp;
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }
}
