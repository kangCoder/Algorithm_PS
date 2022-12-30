package backtracking.boj_2529_부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int k;
    public static char[] inEqualitySign;
    public static boolean[] isUsed = new boolean[10]; //0~9까지의 수를 사용했는지 여부
    public static char[] output;
    public static String maxString, minString;
    public static long MAX = Long.MIN_VALUE, MIN = Long.MAX_VALUE;

    public static void makeNumber(int length) {
        if (length == k + 1) {
            long x = Long.parseLong(new String(output));
            if (x > MAX) {
                MAX = x;
                maxString = new String(output);
            }
            if (x < MIN) {
                MIN = x;
                minString = new String(output);
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                output[length] = Character.forDigit(i, 10);

                if (length > 0) {
                    if (inEqualitySign[length - 1] == '<') {
                        if (output[length - 1] - '0' < output[length] - '0') {
                            makeNumber(length + 1);
                        }
                    }
                    if (inEqualitySign[length - 1] == '>') {
                        if (output[length - 1] - '0' > output[length] - '0') {
                            makeNumber(length + 1);
                        }
                    }
                } else {
                    makeNumber(length + 1);
                }

                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        inEqualitySign = new char[k];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            inEqualitySign[i] = st.nextToken().charAt(0);
        }

        output = new char[k + 1];

        makeNumber(0);

        System.out.println(maxString);
        System.out.println(minString);
    }

}
