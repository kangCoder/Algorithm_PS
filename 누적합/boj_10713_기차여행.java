package 누적합;

import java.util.*;
import java.io.*;

public class boj_10713_기차여행 {

    static int N, M;
    static long ans = 0L, k = 0L;
    static int[] P, visit; //P[i]; i일째에 도시 Pi로 이동, visit[i]: i번 철도를 몇 번 방문하는지
    static int[][] cost; //cost[i][j]: 철도 i를 이용할 때 드는 cost j

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = new int[M + 1];
        visit = new int[N + 1];
        cost = new int[N + 1][3];

        //i일째에 도시 Pi에서 Pi+1로 이동
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        //누적합 적용
        //P = [1, 3, 2, 4]라고 헸을 때
        //1  2  3  4
        //+     -
        //   +  -
        //   +     -
        for (int i = 2; i <= M; i++) {
            int prev = P[i - 1], nxt = P[i];

            if (prev > nxt) {
                int tmp = prev;
                prev = nxt;
                nxt = tmp;
            }

            visit[prev]++;
            visit[nxt]--;
        }

        //철도 i를 이용할 때 드는 cost
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); //티켓 가격
            cost[i][1] = Integer.parseInt(st.nextToken()); //카드 사용 가격
            cost[i][2] = Integer.parseInt(st.nextToken()); //IC카드 구매 가격
        }

        //각 철도를 몇 번 지나치는지 계산하고(K) A*K 와 B*K+IC 를 비교하면 될듯
        for (int i = 1; i < N; i++) {
            k += visit[i];
            //System.out.println(i + "번째 철도 방문 회수=" + k);
            long min = Math.min(cost[i][0] * k, cost[i][1] * k + cost[i][2]);
            ans += min;
        }

        System.out.println(ans);
    }

}
