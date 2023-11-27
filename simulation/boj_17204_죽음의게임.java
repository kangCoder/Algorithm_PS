package simulation;

import java.io.*;
import java.util.*;

public class boj_17204_죽음의게임 {

    static int N, K, ans = 0; //사람의 수, 타겟 번호
    static int[] A; //지목하는 사람 번호
    static boolean[] check; //한 번 지목된 사람인지 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        check = new boolean[N];

        int idx = 0; //현재 지목할 사람
        boolean failed = false;
        while (true) {
            if (check[idx]) {
                failed = true;
                break;
            }

            check[idx] = true;
            if (idx == K) {
                break;
            }

            idx = A[idx];
            ans++;
        }

        System.out.println(failed ? "-1" : ans);
    }
}