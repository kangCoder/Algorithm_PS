package 삼성SW역량준비.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_8898_3차원농부 {

    public static int N, M;
    public static int[] cows;

    public static int binarySearch(int target) {
        int left = 0, right = cows.length - 1;
        int mid = (left + right) / 2;

        if (target < cows[left]) {
            return 0;
        } else if (target > cows[right]) {
            return cows.length - 1;
        }

        while (left <= right) {
            mid = (left + right) / 2;
            if (cows[mid] == target) {
                return mid;
            } else if (cows[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (cows[mid] < target) {
            mid++;
        }

        return mid;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int dx = Math.abs(c1 - c2);

            cows = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cows[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cows);

            int min = Integer.MAX_VALUE, count = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                int horsePos = Integer.parseInt(st.nextToken());
                int cowIdx = binarySearch(horsePos);

                if (cowIdx >= 0 && cowIdx < N) {
                    int cowPos = cows[cowIdx];
                    int dz = Math.abs(cowPos - horsePos);

                    if (min > dz) {
                        min = dz;
                        count = 1;
                    } else if (min == dz) {
                        count++;
                    }
                }

                if (cowIdx > 0 && cowIdx < N && cows[cowIdx] != horsePos) {
                    int cowPos = cows[cowIdx - 1];
                    int dz = Math.abs(cowPos - horsePos);

                    if (min > dz) {
                        min = dz;
                        count = 1;
                    } else if (min == dz) {
                        count++;
                    }
                }
            }

            System.out.println("#" + tc + " " + (dx + min) + " " + count);
        }


    }

}
