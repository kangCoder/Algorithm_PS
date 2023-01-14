package backtracking.programmers_2023카카오_미로탈출명령어;

public class Solution {

    public static String answer = "z";

    //거리가 중요...
    //사전순으로 빠른 경로이므로 먼저 갈 경로도 사전순으로 가야 함. d -> l -> r -> u
    //이렇게 안하니까 시간초과
    public static int[] dy = {0, -1, 1, 0};
    public static int[] dx = {1, 0, 0, -1};
    public static char[] move = {'d', 'l', 'r', 'u'};

    public static void dfs(int n, int m, int x, int y, int r, int c, int k, int count, String path) {
        if (k < count + Math.abs(x - r) + Math.abs(y - c)) {
            return;
        }
        if (x == r && y == c && count == k) {
            answer = path;
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 1 && ny >= 1 && nx <= n && ny <= m && path.compareTo(answer) < 0) {
                dfs(n, m, nx, ny, r, c, k, count + 1, path + move[dir]);
            }
        }
    }

    public static String solution(int n, int m, int x, int y, int r, int c, int k) {
        //절대 거리가 k보다 멀거나 적더라도 홀수인 경우 k로 갈 수 없으므로 불가능
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if ((k - dist) % 2 == 1 || k < dist) {
            return "impossible";
        }

        dfs(n, m, x, y, r, c, k, 0, "");
        return answer;
    }

    public static void main(String[] args) {
        String ans = solution(3, 3, 1, 2, 3, 3, 4);
        System.out.println(ans);
    }

}
