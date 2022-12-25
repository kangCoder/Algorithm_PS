package 자료구조.boj_10816_숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[] source; //key: 카드에 적혀있는 숫자, value: 숫자 카운트

    public static int lowerBound(int target) {
        int start = 0, end = source.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (source[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return end;
    }

    public static int upperBound(int target) {
        int start = 0, end = source.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (source[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        source = new int[N]; //상근이가 가지고 있는 카드
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < source.length; i++) {
            source[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(source);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(key) - lowerBound(key) + " ");
        }
        System.out.println(sb);

    }
}
