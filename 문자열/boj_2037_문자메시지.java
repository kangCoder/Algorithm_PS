package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2037_문자메시지 {

    public static char[] numbers = {
            2, 2, 2,
            3, 3, 3,
            4, 4, 4,
            5, 5, 5,
            6, 6, 6,
            7, 7, 7, 7,
            8, 8, 8,
            9, 9, 9, 9
    };

    public static char[] press = {
            1, 2, 3,
            1, 2, 3,
            1, 2, 3,
            1, 2, 3,
            1, 2, 3,
            1, 2, 3, 4,
            1, 2, 3,
            1, 2, 3, 4
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken()); //버튼을 한 번 누르는데 걸리는 시간
        int w = Integer.parseInt(st.nextToken()); //같은 숫자인 문자를 연속으로 찍기 위해 기다리는 시간
        // (ABC, DEF, GRI, JKL, MNO, PQRS, TUV, WXYZ)

        char[] str = br.readLine().toCharArray();
        int time = 0;
        for (int i = 0; i < str.length; i++) {
            if (i > 0 && Character.isAlphabetic(str[i]) && Character.isAlphabetic(str[i - 1])) {
                if (numbers[str[i] - 'A'] == numbers[str[i - 1] - 'A']) {
                    time += w;
                }
            }

            if (Character.isAlphabetic(str[i])) {
                time += press[str[i] - 'A'] * p;
            } else {
                time += p;
            }
        }

        System.out.println(time);
    }

}
