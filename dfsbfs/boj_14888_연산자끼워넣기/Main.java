package dfsbfs.boj_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public final static int PLUS = 0, MINUS = 1, MULTIPLE = 2, DIVIDE = 3;
    public static int N;
    public static int[] A;
    public static int[] op = new int[4];
    public static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

    public static void backTracking(int depth, int sum) {
        if (depth == N) {
            MAX = Integer.max(sum, MAX);
            MIN = Integer.min(sum, MIN);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--; //해당 연산자를 사용하기 때문에 개수 감소

                switch (i) {
                    case PLUS:
                        backTracking(depth + 1, sum + A[depth]);
                        break;
                    case MINUS:
                        backTracking(depth + 1, sum - A[depth]);
                        break;
                    case MULTIPLE:
                        backTracking(depth + 1, sum * A[depth]);
                        break;
                    case DIVIDE:
                        backTracking(depth + 1, sum / A[depth]);
                        break;
                }

                op[i]++; //해당 연산자의 사용이 끝났기 때문에 다시 +1
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(1, A[0]); //0번째 인덱스와 1번째 인덱스를 연산하는 것부터 시작.
        System.out.println(MAX);
        System.out.println(MIN);
    }
}
