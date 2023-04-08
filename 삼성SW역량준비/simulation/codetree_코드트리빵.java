package 삼성SW역량준비.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class codetree_코드트리빵 {

    static int n, m;
    static int[][] grid; //0: 빈 공간, 1: 베이스캠프, 2: 이미 방문한 베이스 캠프 3: 사람이 있는 편의점
    static int[][] shortDist;
    static boolean[][] visited;
    static People[] people;

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static int[] findBaseCamp(People person) {
        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][n];

        q.add(new int[]{person.storeX, person.storeY});
        visited[person.storeX][person.storeY] = true;

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                //행이 더 작고, 같다면 열이 더 작은 베이스캠프를 찾아야 하므로 상-좌-하-우 순으로 탐색.
                int nx = pos[0] + dx[dir];
                int ny = pos[1] + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                if (grid[nx][ny] == 0 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                } else if (grid[nx][ny] == 1) {
                    return new int[]{nx, ny};
                }
            }
        }

        return new int[]{-1, -1};
    }


    public static void move(People person) {
        //편의점부터 현재 위치까지의 최단 거리를 구한 뒤 경로의 값을 shortDist 배열에 저장.
        bfs(new int[]{person.storeX, person.storeY});

        int minDist = Integer.MAX_VALUE;
        int minX = -1, minY = -1;
        //현재 위치에서 상-좌-우-하 돌려서 가장 값이 낮은 곳으로 한 칸 이동
        for (int dir = 0; dir < 4; dir++) {
            int nx = person.curX + dx[dir];
            int ny = person.curY + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            if (visited[nx][ny] && minDist > shortDist[nx][ny]) {
                minX = nx;
                minY = ny;
                minDist = shortDist[nx][ny];
            }
        }

        person.curX = minX;
        person.curY = minY;
    }

    public static void bfs(int[] storePos) {
        visited = new boolean[n][n];
        shortDist = new int[n][n];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{storePos[0], storePos[1]});
        visited[storePos[0]][storePos[1]] = true;

        while (!q.isEmpty()) {
            int[] curPos = q.poll();
            int curX = curPos[0], curY = curPos[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

                if ((grid[nx][ny] == 0 || grid[nx][ny] == 1) && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    shortDist[nx][ny] = shortDist[curX][curY] + 1;
                }
            }
        }
    }

    public static void updateStore() {
        for (int i = 1; i <= m; i++) {
            if (people[i].isSame()) {
                grid[people[i].curX][people[i].curY] = 3;
            }
        }
    }

    public static boolean isEnd() {
        for (int i = 1; i <= m; i++) {
            if (!people[i].isSame()) {
                return false;
            }
        }
        return true;
    }

    public static int solve() {
        int currentTime = 0;

        while (true) {
            currentTime++;
            for (int i = 1; i <= m; i++) {
                if (!people[i].isGrid() || people[i].isSame()) {
                    continue;
                }

                //1. 격자에 있는 사람들 한 칸씩 움직이기
                move(people[i]);
            }

            //2. 다 움직였으면 편의점에 있는지 업데이트
            updateStore();

            //3. 현재 시간에 해당하는 사람 베이스캠프로 넣어주기
            if (currentTime <= m) {
                int[] basecamp = findBaseCamp(people[currentTime]);
                //해당 사람의 위치를 찾은 베이스캠프의 위치로 초기화.
                people[currentTime].curX = basecamp[0];
                people[currentTime].curY = basecamp[1];
                //베이스 캠프 방문 표시 (이제 이 곳은 아무도 못감)
                grid[basecamp[0]][basecamp[1]] = 2;
            }

            if (isEnd()) {
                break;
            }
        }

        return currentTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        people = new People[m + 1];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new People(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
        }

        visited = new boolean[n][n];

        int ans = solve();
        System.out.println(ans);
    }

    static class People {

        int storeX, storeY;
        int curX, curY;

        public People(int storeX, int storeY) {
            this.storeX = storeX;
            this.storeY = storeY;
            this.curX = -1;
            this.curY = -1;
        }

        public boolean isSame() {
            return (curX == storeX && curY == storeY);
        }

        public boolean isGrid() {
            return (curX != -1 && curY != -1);
        }
    }

}
