package backtracking;

import java.util.*;
import java.io.*;

public class boj_18429_근손실 {

    static int N, K, ans = 0; //날짜, 감소 중량
    static int[] A; //운동 키트
    static boolean[] isUsed;
    static int[] select;

    static boolean check500() {
        int weight = 500;
        for (int w : select) {
            weight += w;
            weight -= K;
            if (weight < 500) {
                return false;
            }
        }

        return true;
    }

    static void dfs(int cur) {
        if (cur == N) {
            if (check500()) {
                ans++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                select[cur] = A[i];
                dfs(cur + 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //1. 운동 키트 적용 순서 정하기
        //2. 적용 순서대로 진행하면서 500 넘기는지 확인하기

        isUsed = new boolean[N];
        select = new int[N];
        dfs(0);

        System.out.println(ans);
    }

}
