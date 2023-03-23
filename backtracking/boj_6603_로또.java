package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_6603_로또 {

    public static boolean[] visited;

    public static void makeLotto(int[] lotto, int start, int r) {
        if (r == 0) {
            print(lotto);
            return;
        }

        for (int i = start; i < lotto.length; i++) {
            visited[i] = true;
            makeLotto(lotto, i + 1, r - 1);
            visited[i] = false;
        }
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] s = br.readLine().split(" ");
            int[] tc = Arrays.stream(s)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (tc[0] == 0) {
                break;
            }

            int[] lotto = new int[tc.length - 1];
            visited = new boolean[tc.length - 1];
            for (int i = 1; i < tc.length; i++) {
                lotto[i - 1] = tc[i];
            }

            makeLotto(lotto, 0, 6);
            System.out.println();
        }
    }

}
