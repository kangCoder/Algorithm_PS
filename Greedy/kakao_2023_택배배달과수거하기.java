package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kakao_2023_택배배달과수거하기 {

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0L;

        //물류창고에서 가장 먼 집부터 다녀오는게 그리디함. -> 배열을 뒤집자 일단.
        int[] reverseDeli = new int[deliveries.length];
        int[] reversePick = new int[pickups.length];

        for (int i = n - 1, j = 0; i >= 0; i--, j++) {
            reverseDeli[j] = deliveries[i];
            reversePick[j] = pickups[i];
        }

        int canPick = 0, canDeli = 0;

        for (int i = 0; i < n; i++) {
            canPick += reversePick[i];
            canDeli += reverseDeli[i];

            while (canPick > 0 || canDeli > 0) {
                canPick -= cap;
                canDeli -= cap;
                answer += (n - i) * 2L;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cap = Integer.parseInt(st.nextToken());

        int[] deliveries = new int[n]; //집에 배달할 재활용 택배 상자의 개수
        int[] pickups = new int[n]; //집에서 수거할 빈 재활용 택배 상자의 개수

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deliveries[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pickups[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(cap, n, deliveries, pickups));
    }
}
