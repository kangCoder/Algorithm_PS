package binarysearch;

import java.util.*;
import java.io.*;

public class boj_16401_과자나눠주기 {

    static int M, N, max = Integer.MIN_VALUE;
    static int[] cookies;

    static int binarySearch(int left, int right, int target) {
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            //동등하게 쿠키를 나눠줄 수 있는지 확인
            int cnt = 0;
            for (int cookie : cookies) {
                cnt += cookie / mid;
            }

            if (cnt >= target) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        cookies = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cookies[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, cookies[i]);
        }

        System.out.println(binarySearch(1, max, M));
    }
}