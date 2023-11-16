package 삼성SW역량준비.simulation;

import java.io.*;
import java.util.*;

public class swea_View {

    static int N, ans;
    static int[] towerHeights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            ans = 0;
            N = Integer.parseInt(br.readLine());

            towerHeights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                towerHeights[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i < N - 2; i++) {
                int height = towerHeights[i];
                int leftMaxHeight = Math.max(towerHeights[i - 1], towerHeights[i - 2]);
                int rightMaxHeight = Math.max(towerHeights[i + 1], towerHeights[i + 2]);

                if (height > leftMaxHeight && height > rightMaxHeight) {
                    ans += height - Math.max(leftMaxHeight, rightMaxHeight);
                }
            }

            bw.write("#"+tc+" "+ans+"\n");
        }

        bw.flush();
    }
}
