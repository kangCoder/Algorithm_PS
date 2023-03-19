import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7562_나이트의이동 {

    public static int I;
    public static int[] dx = {-2, -1, 2, 1, 2, 1, -2, -1};
    public static int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};
    public static int[][] map;
    public static boolean[][] visited;

    public static int bfs(Node[] nodes) {
        Queue<Node> q = new LinkedList<>();
        q.offer(nodes[0]); //시작점 추가

        visited[nodes[0].x][nodes[0].y] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.x == nodes[1].x && n.y == nodes[1].y) {
                return n.cnt;
            }

            for (int dir = 0; dir < 8; dir++) {
                int nx = n.x + dx[dir];
                int ny = n.y + dy[dir];

                if (nx < 0 || nx >= I || ny < 0 || ny >= I) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, n.cnt + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visited = new boolean[I][I];

            Node[] nodes = new Node[2];
            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int nextX = Integer.parseInt(st.nextToken());
            int nextY = Integer.parseInt(st.nextToken());

            nodes[0] = new Node(curX, curY);
            nodes[1] = new Node(nextX, nextY);

            System.out.println(bfs(nodes));
        }
    }

    public static class Node {

        int x, y, cnt;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
            this.cnt = 0;
        }

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

}
