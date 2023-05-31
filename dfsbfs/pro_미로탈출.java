package dfsbfs;

import java.util.*;

public class pro_미로탈출 {

    private Queue<Node> q;
    private char[][] map;
    private boolean[][] visited;
    private int[] dr = {1, -1, 0, 0};
    private int[] dc = {0, 0, 1, -1};

    public int solution(String[] maps) {
        q = new LinkedList<>();

        map = new char[maps.length][maps[0].length()];
        visited = new boolean[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    q.offer(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // 1. start에서 레버까지의 최단 경로를 찾는다.
        Node lever = findLever();

        // 2. 레버를 당겼는지 확인.
        if (lever == null) {
            return -1;
        }

        // 3. 레버에서 출구까지의 최단 경로를 찾는다.
        return findExit(lever);
    }

    private Node findLever() {
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || map[nr][nc] == 'X') {
                    continue;
                }

                // 레버를 찾았으면 위치를 업데이트하고, 함수를 종료한다.
                if (map[nr][nc] == 'L') {
                    return new Node(nr, nc, cur.time + 1);
                }

                if (!visited[nr][nc]) {
                    q.offer(new Node(nr, nc, cur.time + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        return null; // 레버를 찾지 못한 경우
    }

    private int findExit(Node start) {
        q.clear();
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], false);
        }

        q.offer(start);
        visited[start.r][start.c] = true;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if (nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length || map[nr][nc] == 'X') {
                    continue;
                }

                if (map[nr][nc] == 'E') {
                    return cur.time + 1;
                }

                if (!visited[nr][nc]) {
                    q.offer(new Node(nr, nc, cur.time + 1));
                    visited[nr][nc] = true;
                }
            }
        }

        return -1; // 출구를 찾지 못한 경우
    }

    class Node {

        int r, c;
        int time;

        public Node(int r, int c, int time) {
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

}
