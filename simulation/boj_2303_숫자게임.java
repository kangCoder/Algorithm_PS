package simulation;

import java.io.*;
import java.util.*;

public class boj_2303_숫자게임 {

    static int N, ans = 1;
    static int[][] card;
    static int[] max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        card = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = j + 1; k < 4; k++) {
                    for (int l = k + 1; l < 5; l++) {
                        max[i] = Math.max(max[i], (card[i][j] + card[i][k] + card[i][l]) % 10);
                    }
                }
            }
        }

        int tmpMax = max[0];
        for (int i = 1; i < N; i++) {
            if (tmpMax <= max[i]) {
                tmpMax = max[i];
                ans = i + 1;
            }
        }

        System.out.println(ans);
    }
}
