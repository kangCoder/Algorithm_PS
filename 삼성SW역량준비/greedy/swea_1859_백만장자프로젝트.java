package 삼성SW역량준비.greedy;

import java.io.*;
import java.util.*;

public class swea_1859_백만장자프로젝트 {

    static int N;
    static long ans;
    static int[] days;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0L;
            N = Integer.parseInt(br.readLine());

            days = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                days[i] = Integer.parseInt(st.nextToken());
            }

            int maxPrice = days[N - 1]; //마지막 날의 매매가를 초기 최대 매매가로 설정.
            for (int day = N - 1; day >= 0; day--) {
                if (maxPrice > days[day]) {
                    ans += maxPrice - days[day]; //최대 매매가보다 매매가가 작다면 이 날 사서 최대 매매가 날짜에 팔면 읻득
                } else {
                    maxPrice = days[day];
                }
            }

            bw.write("#" + tc + " " + ans + "\n");
        }

        bw.flush();
    }
}
