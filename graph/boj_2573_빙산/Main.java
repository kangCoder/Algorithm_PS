package graph.boj_2573_빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static int N, M;
    public static int[][] iceberg;
    public static boolean[][] visited;
    public static int year = 0; //총 걸린 년수(정답)
    public static int icebergCount = 0;
    public static int[] dy = {0, 1, 0, -1};
    public static int[] dx = {1, 0, -1, 0};

    public static void aYearLater() {
        int[][] copyIceberg = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(iceberg[i], 0, copyIceberg[i], 0, iceberg[0].length);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int minus = 0;
                if (copyIceberg[i][j] != 0) {
                    for (int dir = 0; dir < 4; dir++) {
                        int nextR = i + dy[dir];
                        int nextC = j + dx[dir];
                        if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
                            if (copyIceberg[nextR][nextC] == 0) {
                                minus++;
                            }
                        }
                    }
                    if (iceberg[i][j] < minus) {
                        iceberg[i][j] = 0;
                    } else {
                        iceberg[i][j] -= minus;
                    }
                }
            }
        }
        year++;
    }

    public static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nextR = cur.r + dy[dir];
                int nextC = cur.c + dx[dir];
                if (nextR >= 0 && nextC >= 0 && nextR < N && nextC < M) {
                    if (iceberg[nextR][nextC] != 0 && !visited[nextR][nextC]) {
                        queue.add(new Node(nextR, nextC));
                        visited[nextR][nextC] = true;
                    }
                }
            }
        }
    }

    public static void findIceberg(int r, int c) {
        bfs(r, c);
        icebergCount++;
    }

    //맨처음에 빙산이 몇개인지 파악 -> 1개라면 bfs돌려서 얼음이 남아있는지 확인 -> 반복
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        iceberg = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][M];
            icebergCount = 0;

            //빙산이 몇 개인지 파악
            boolean isEmpty = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (iceberg[i][j] != 0 && !visited[i][j]) {
                        findIceberg(i, j);
                        isEmpty = false;
                    }
                }
            }

            //빙산이 1개보다 많다면 정답을 출력하고 종료
            if(icebergCount > 1) {
                System.out.println(year);
                break;
            }

            //빙산이 0개라면 다 녹을 때까지 분리가 안됐다는 뜻이므로 0을 출력하고 종료
            if(isEmpty) {
                System.out.println(0);
                break;
            }

            //빙산이 1개라는 뜻이므로 1년 후로 넘김
            aYearLater();
        }

    }

    public static class Node {

        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

}
