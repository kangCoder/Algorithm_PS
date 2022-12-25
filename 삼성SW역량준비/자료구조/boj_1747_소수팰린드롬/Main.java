package 삼성SW역량준비.자료구조.boj_1747_소수팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int N;

    public static boolean isPrime(int x) {
        //에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder sb = new StringBuilder(s);
        if (s.equals(sb.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //1인 경우의 예외처리 해줘야 함.
        if (N == 1) {
            System.out.println(2);
            System.exit(0);
        }

        for (int i = N; ; i++) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                System.exit(0);
            }
        }
    }
}
