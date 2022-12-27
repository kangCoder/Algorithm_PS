package 삼성SW역량준비.dfs.boj_1759_암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int L, C;
    public static char[] arr, output;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        output = new char[L];

        dfs(0, 0);
    }

    public static void dfs(int depth, int x) {
        if (depth == L) {
            if (isValid(output)) {
                System.out.println(output);
            }
            return;
        }

        for (int i = x; i < C; i++) {
            output[depth] = arr[i];
            dfs(depth + 1, i + 1);
        }
    }

    public static boolean isValid(char[] output) {
        int cons = 0, vow = 0;
        for (char c : output) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o'
                    || c == 'u') {
                vow++;
            } else {
                cons++;
            }
        }

        return cons >= 2 && vow >= 1;
    }
}
