package greedy.boj_1744_수묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int[] answer = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            answer[i] = arr[i - 1] + answer[i - 1];
            if (i > 1) {
                answer[i] = Math.max(answer[i], answer[i - 2] + (arr[i - 2] * arr[i - 1]));
            }
        }

        System.out.println(answer[N]);
    }
}
