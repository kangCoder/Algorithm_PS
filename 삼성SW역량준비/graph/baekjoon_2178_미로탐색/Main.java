package 삼성SW역량준비.graph.baekjoon_2178_미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M; //N:row, M:col
    public static int[][] arr;
    public static boolean[][] visited;

    public static class Node {

        int row, col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static int bfs() {
        int[][] ans = new int[N][M];
        Queue<Node> queue = new LinkedList<>();
        visited[0][0] = true;
        ans[0][0] = 1;
        queue.add(new Node(0, 0));
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};


        while (!queue.isEmpty()) {
            Node next = queue.poll();

            if (arr[next.row][next.col] == 1) {
                for (int dir = 0; dir < 4; dir++) {
                    int row = next.row + dy[dir];
                    int col = next.col + dx[dir];

                    if (row >= 0 && col >= 0 && row < N && col < M) {
                        if (!visited[row][col]) {
                            queue.add(new Node(row, col));
                            visited[row][col] = true;
                            ans[row][col] = ans[next.row][next.col] + 1;
                        }
                    }
                }
            }
        }
        return ans[N - 1][M - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < arr.length; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.println(bfs());
    }
}
