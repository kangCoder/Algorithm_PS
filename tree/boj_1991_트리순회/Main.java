package tree.boj_1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static char[] lc = new char[30];
    public static char[] rc = new char[30];

    public static void preOrder(char cur) {
        System.out.print(cur);
        if (lc[cur - 'A' + 1] != 0) {
            preOrder(lc[cur - 'A' + 1]);
        }
        if (rc[cur - 'A' + 1] != 0) {
            preOrder(rc[cur - 'A' + 1]);
        }
    }

    public static void inOrder(char cur) {
        if (lc[cur - 'A' + 1] != 0) {
            inOrder(lc[cur - 'A' + 1]);
        }
        System.out.print(cur);
        if (rc[cur - 'A' + 1] != 0) {
            inOrder(rc[cur - 'A' + 1]);
        }
    }

    public static void postOrder(char cur) {
        if (lc[cur - 'A' + 1] != 0) {
            postOrder(lc[cur - 'A' + 1]);
        }
        if (rc[cur - 'A' + 1] != 0) {
            postOrder(rc[cur - 'A' + 1]);
        }
        System.out.print(cur);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char cur, left, right;
            st = new StringTokenizer(br.readLine());
            cur = st.nextToken().charAt(0);
            left = st.nextToken().charAt(0);
            right = st.nextToken().charAt(0);
            if (left != '.') {
                lc[cur - 'A' + 1] = left;
            }
            if (right != '.') {
                rc[cur - 'A' + 1] = right;
            }
        }

        preOrder('A');
        System.out.println();
        inOrder('A');
        System.out.println();
        postOrder('A');
        System.out.println();
    }
}
