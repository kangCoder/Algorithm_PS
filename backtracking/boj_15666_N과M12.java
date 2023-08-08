package backtracking;

import java.util.*;
import java.io.*;

public class boj_15666_N과M12 {

    static Set<String> set = new HashSet<>();
    static List<String> ans = new ArrayList<>();
    static int N, M;
    static int[] input, output;

    static void backTracking(int length) {
        if (length == M) {
            if (isInDescending()) {
                StringBuilder sb = new StringBuilder();
                for (int i : output) {
                    sb.append(i).append(" ");
                }
                if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
                    ans.add(sb.toString());
                }
            }

            return;
        }

        for (int i : input) {
            output[length] = i;
            backTracking(length + 1);
        }
    }

    static boolean isInDescending() {
        for (int i = 0; i < output.length - 1; i++) {
            if (output[i] > output[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        output = new int[M];
        backTracking(0);

        for (String s : ans) {
            System.out.println(s);
        }
    }

}
