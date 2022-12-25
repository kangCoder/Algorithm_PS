package greedy.boj_1931_회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // start
            arr[i][1] = Integer.parseInt(st.nextToken()); // end
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0]; // 종료시간이 같다면 아무거나 상관없음.
            }
            return a[1] - b[1]; // 종료시간이 빠른 순으로 정렬
        });

        int count = 0, end = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i][0] >= end) {
                // 시작 시간이 종료시간 뒤라면
                end = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
