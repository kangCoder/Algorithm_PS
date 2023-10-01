package backtracking;

public class pro_피로도 {

    private int answer = 0;
    private boolean[] visited;

    //(현재 던전을 몇 개 돌았는지 카운트, 현재 피로도, 던전)
    private void dfs(int k, int[][] dungeons) {
        int cnt = 0;
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                cnt++;
            }
        }
        answer = Math.max(answer, cnt);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]) {
                    visited[i] = true;
                    k -= dungeons[i][1];
                    dfs(k, dungeons);
                    k += dungeons[i][1];
                    visited[i] = false;
                }
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        int length = dungeons.length;

        dfs(k, dungeons);
        return answer;
    }
}
