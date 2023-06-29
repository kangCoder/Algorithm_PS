package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2232_지뢰 {

    static int N;
    static int[] mines;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        mines = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            mines[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        if (mines[1] >= mines[2]) {
            System.out.println(1);
        }
        for (int i = 2; i < N; i++) {
            if (mines[i - 1] <= mines[i] && mines[i] >= mines[i + 1]) {
                System.out.println(i);
            }
        }
        if (mines[N] >= mines[N - 1]) {
            System.out.println(N);
        }
    }
}