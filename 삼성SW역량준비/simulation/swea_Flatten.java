package 삼성SW역량준비.simulation;

import java.io.*;
import java.util.*;

public class swea_Flatten {

    static int ans;
    static int[] boxes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {
            ans = 0;
            int maxIdx = 0, minIdx = 0;
            int dump = Integer.parseInt(br.readLine());

            boxes = new int[100];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
                if (boxes[maxIdx] < boxes[i]) {
                    maxIdx = i;
                }
                if (boxes[minIdx] > boxes[i]) {
                    minIdx = i;
                }
            }

            ans = Math.abs(boxes[maxIdx] - boxes[minIdx]);
            for (int d = 1; d <= dump; d++) {
                if (ans <= 1) {
                    break;
                }

                boxes[maxIdx]--;
                boxes[minIdx]++;

                for (int i = 0; i < 100; i++) {
                    if (boxes[maxIdx] < boxes[i]) {
                        maxIdx = i;
                    }
                    if (boxes[minIdx] > boxes[i]) {
                        minIdx = i;
                    }
                }

                ans = Math.abs(boxes[maxIdx] - boxes[minIdx]);
            }

            bw.write("#" + tc + " " + ans + "\n");
        }

        bw.flush();
    }
}