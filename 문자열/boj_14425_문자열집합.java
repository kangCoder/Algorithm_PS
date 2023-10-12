package 문자열;

import java.util.*;
import java.io.*;

public class boj_14425_문자열집합 {

    static int N, M, ans = 0; //문자열의 개수
    static HashSet<String> S; //포함 문자열, 검사 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        S = new HashSet<>();
        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (S.contains(br.readLine())) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
