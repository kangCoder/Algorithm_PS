package bruteforce.boj_14888_연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    public final static int PLUS = 0, MINUS = 1, MULTIPLE = 2, DIVIDE = 3;
    public static int N;
    public static int[] A;
    public static int[] op = new int[4];
    public static boolean[] visited;
    public static Vector<Integer> opVector = new Vector<>();
    public static int[] output;
    public static int MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;

    public static void permutation(int depth) {
        if (depth == N - 1) {
            calculate(output);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = opVector.get(i);
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculate(int[] output) {
        int sum = A[0];
        for (int i = 0; i < N - 1; i++) {
            switch (output[i]) {
                case PLUS:
                    sum += A[i + 1];
                    break;
                case MINUS:
                    sum -= A[i + 1];
                    break;
                case MULTIPLE:
                    sum *= A[i + 1];
                    break;
                case DIVIDE:
                    sum /= A[i + 1];
                    break;
            }
        }
        MAX = Integer.max(sum, MAX);
        MIN = Integer.min(sum, MIN);
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
        for (int i = 0; i < 4; i++) {
            while (op[i] > 0) {
                opVector.add(i);
                op[i]--;
            }
        }
        visited = new boolean[opVector.size()];
        output = new int[opVector.size()];

        permutation(0);
        System.out.println(MAX);
        System.out.println(MIN);

    }
}
