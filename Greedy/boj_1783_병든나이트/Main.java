package greedy.boj_1783_병든나이트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;
        if (N == 1) {
            answer = 1;
        } else if (N == 2) {
            // N = 2인 경우, 가로로는 2칸씩만 이동할 수 있음
            answer = Math.min(4, (M + 1) / 2);
        } else if (M < 7) {
            // 4가지 방법을 다 사용하기 위해서는 M이 7 이상이어야 함.
            answer = Math.min(4, M);
        } else {
            // 4가지 방법을 다 사용했을 때, 가로로 2칸씩 가는 경우가 2번 있으므로 -2를 해줘야 함.
            answer = M - 2;
        }

        System.out.println(answer);
    }
}
