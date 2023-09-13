package binarysearch;

import java.util.*;
import java.io.*;

public class boj_11663_선분위의점 {

    static int N, M;
    static long[] dots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dots = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dots[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(dots);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());

            //start보다 같거나 작은 첫번째 점 찾기
            int left = 0, right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (dots[mid] >= start) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int min = left;

            //end보다 큰 첫번째 점 찾기
            left = 0;
            right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (dots[mid] > end) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int max = left;

            //둘을 뺀다.
            System.out.println(max - min);
        }
    }

}
