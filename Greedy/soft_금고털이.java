package greedy;

import java.util.*;
import java.io.*;

public class soft_금고털이 {

    static int N, W, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); //배낭의 무게
        N = Integer.parseInt(st.nextToken()); //금속의 종류(개수)

        int[][] items = new int[N][2]; //0: 금속의 무게, 1: 무게당 가격
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(items, (a, b) -> b[1] - a[1]);

        //앞에서부터 넣고, 부족하면 잘라서 채우기
        int allowWeight = W;
        for (int i = 0; i < N; i++) {
            if (allowWeight >= items[i][0]) {
                //i번째 금속을 다 넣을 수 있으면, (i번째 금속 * 무게당 가격)을 더한다.
                answer += items[i][0] * items[i][1];
                allowWeight -= items[i][0];
            } else {
                //i번째 금속을 다 넣지 못할 경우, 아직 공간이 남았다면 그만큼 잘라서 넣는다.
                if (allowWeight > 0) {
                    answer += allowWeight * items[i][1];
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}