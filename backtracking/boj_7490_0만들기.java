package backtracking;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class boj_7490_0만들기 {

    static int N;
    static StringBuilder sb = new StringBuilder();

    static int calculate(String s) {
        s = s.replaceAll(" ", ""); //공백 제거

        //연산자 지우고 숫자만 남기기
        Iterator<Integer> it = Arrays.stream(s.split("[+,-]"))
                .map(Integer::parseInt)
                .collect(Collectors.toList()).iterator();

        int result = it.next();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                result += it.next();
            } else if (s.charAt(i) == '-') {
                result -= it.next();
            }
        }

        return result;
    }

    static void backTracking(int cur, String s) {
        if (cur == N) {
            if (calculate(s) == 0) {
                sb.append(s).append("\n");
            }
            return;
        }

        backTracking(cur + 1, s + ' ' + (cur + 1));
        backTracking(cur + 1, s + '+' + (cur + 1));
        backTracking(cur + 1, s + '-' + (cur + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            backTracking(1, "1");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
