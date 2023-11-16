package 삼성SW역량준비.backtracking;

import java.io.*;
import java.util.*;

public class swea_최대상금 {

    static int N, ans;
    static int[] numbers;

    static void swap(int a, int b) {
        int tmp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = tmp;
    }

    static void makeNumber(int cnt, int src) {
        //교환 횟수(cnt)가 N번이 되면 그 때의 결과를 갱신
        if (cnt == N) {
            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                sb.append(number);
            }

            //System.out.println(sb);
            ans = Math.max(ans, Integer.parseInt(sb.toString()));
            return;
        }

        //i번째 숫자와 j번째 숫자를 교환
        for (int i = src; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                swap(i, j);
                makeNumber(cnt + 1, src);
                swap(i, j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            String number = st.nextToken();
            N = Integer.parseInt(st.nextToken());
            ans = 0;

            numbers = new int[number.length()];
            for (int i = 0; i < number.length(); i++) {
                numbers[i] = Character.getNumericValue(number.charAt(i));
            }

            //자릿수만큼 교환횟수가 있다면 만들 수 있는 모든 수를 만들 수 있음.
            if (N > numbers.length) {
                N = numbers.length;
            }

            makeNumber(0, 0);
            bw.write("#"+tc+" "+ans+"\n");
        }

        bw.flush();
    }
}