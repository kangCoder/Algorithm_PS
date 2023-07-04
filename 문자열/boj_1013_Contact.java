package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1013_Contact {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String vega = "(100+1+|01)+";
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String wave = br.readLine();
            if (wave.matches(vega)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
