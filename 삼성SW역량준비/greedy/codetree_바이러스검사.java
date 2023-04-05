package 삼성SW역량준비.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codetree_바이러스검사 {

    static int n, leader, member;
    static long ans;
    static int[] cafe;

    public static int solution(int customer) {
        if (customer <= 0) {
            return 0;
        }

        if (customer % member == 0) {
            return customer / member;
        } else {
            return (customer / member) + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ans = 0L;

        cafe = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cafe[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        leader = Integer.parseInt(st.nextToken());
        member = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            cafe[i] -= leader;
            ans++;

            ans += solution(cafe[i]);
        }

        System.out.println(ans);
    }

}
