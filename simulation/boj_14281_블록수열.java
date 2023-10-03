package simulation;

import java.util.*;
import java.io.*;

public class boj_14281_블록수열 {

    static int N;
    static long ans = 0;
    static long[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        //A를 한 번만 순회했을 때 다시 볼록하지 않게 될 수 있으므로 볼록하지 않은 부분이 나오지 않을 때까지 A를 순회한다.
        while (true) {
            long tmp = 0;
            boolean isConvex = true;
            for (int i = 1; i <= N - 2; i++) {
                if (A[i - 1] + A[i + 1] < 2 * A[i]) {
                    long diff = A[i] - (A[i - 1] + A[i + 1]) / 2; //하나씩 안빼고 연산 횟수 한 번에 세기
                    A[i] -= diff;
                    tmp += diff;
                    isConvex = false;
                }
            }
            ans += tmp;

            if (isConvex) {
                break;
            }
        }

        System.out.println(ans);
    }
}
