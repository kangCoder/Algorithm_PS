package dfsbfs;

import java.util.*;

public class pro_리코쳇로봇 {

    private Queue<Node> q;
    private char[][] boards;
    private boolean[][] visited;
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};

    private int bfs() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (boards[cur.r][cur.c] == 'G') {
                return cur.moves;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.r, nc = cur.c;
                int moveR = dr[dir];
                int moveC = dc[dir];

                //moveR, moveC 방향으로 쭉 이동하다가, 장애물 또는 범위를 벗어나면 그 전으로
                while (true) {
                    nr += moveR;
                    nc += moveC;

                    if (nr < 0 || nr >= boards.length || nc < 0 || nc >= boards[0].length) {
                        nr -= moveR;
                        nc -= moveC;
                        break;
                    }

                    if (boards[nr][nc] == 'D') {
                        nr -= moveR;
                        nc -= moveC;
                        break;
                    }
                }

                if (!visited[nr][nc]) {
                    q.offer(new Node(nr, nc, cur.moves + 1));
                    //System.out.println("next r=" + nr + ", next c=" + nc + ", move=" + (cur.moves + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        return -1;
    }

    public int solution(String[] board) {
        q = new LinkedList<>();

        boards = new char[board.length][board[0].length()];
        visited = new boolean[boards.length][boards[0].length];
        for (int i = 0; i < boards.length; i++) {
            String s = board[i];
            for (int j = 0; j < boards[i].length; j++) {
                boards[i][j] = s.charAt(j);
                if (boards[i][j] == 'R') {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        return bfs();
    }

    class Node {

        int r, c;
        int moves;

        public Node(int r, int c, int moves) {
            this.r = r;
            this.c = c;
            this.moves = moves;
        }
    }
}