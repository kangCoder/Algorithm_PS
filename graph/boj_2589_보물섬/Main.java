package graph.boj_2589_보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int ROW, COL, ans = Integer.MIN_VALUE;
    public static char[][] map;
    public static boolean[][] visited;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static int bfs(int r, int c) {
        int dist = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, dist));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nextR = cur.row + dy[dir];
                int nextC = cur.col + dx[dir];
                int curDist = cur.dist;
                dist = cur.dist;
                if (nextR >= 0 && nextC >= 0 && nextR < ROW && nextC < COL) {
                    if (map[nextR][nextC] == 'L' && !visited[nextR][nextC]) {
                        queue.add(new Node(nextR, nextC, curDist + 1));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        map = new char[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < COL; j++) {
                map[i][j] = s[j].charAt(0);
            }
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[ROW][COL];
                    int dist = bfs(i, j);
                    if (dist > ans) {
                        ans = dist;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static class Node {

        int row, col, dist;

        public Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

}
