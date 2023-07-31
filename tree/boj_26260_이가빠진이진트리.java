package tree;

import java.util.*;
import java.io.*;

public class boj_26260_이가빠진이진트리 {

    static int N, X;
    static boolean flag = false;
    static int[] tree;

    static void inOrder(int cur) {
        if (cur < 1 || cur > N) {
            return;
        }
        inOrder(cur * 2);
        if (!flag) {
            if (tree[cur] > X) {
                int tmp = tree[cur];
                tree[cur] = X;
                X = tmp;
            }
        }
        inOrder(cur * 2 + 1);
    }

    static void reverseInOrder(int cur) {
        if (cur < 1 || cur > N) {
            return;
        }
        reverseInOrder(cur * 2 + 1);
        if (tree[cur] == -1) {
            flag = true;
            tree[cur] = X;
        }

        if (!flag) {
            if (tree[cur] < X) {
                int tmp = tree[cur];
                tree[cur] = X;
                X = tmp;
            }
        }
        reverseInOrder(cur * 2);
    }

    static void postOrder(int cur) {
        if (cur < 1 || cur > N) {
            return;
        }
        postOrder(cur * 2);
        postOrder(cur * 2 + 1);
        System.out.print(tree[cur] + " ");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());
        inOrder(1);
        reverseInOrder(1);
        postOrder(1);
    }

}
