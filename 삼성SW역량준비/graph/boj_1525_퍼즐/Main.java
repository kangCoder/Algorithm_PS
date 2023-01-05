package 삼성SW역량준비.graph.boj_1525_퍼즐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static String target = "123456780";
    public static Map<String, Integer> map = new HashMap<>();

    public static int[] dy = {0, 0, 1, -1};
    public static int[] dx = {1, -1, 0, 0};

    public static int bfs(String source) {
        Queue<String> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            String cur = queue.poll();

            int curMove = map.get(cur);
            int emptyLocation = cur.indexOf('0');
            int curY = emptyLocation / 3; //현재 0의 y좌표
            int curX = emptyLocation % 3; //현재 0의 x좌표

            if (cur.equals(target)) {
                return curMove;
            }

            for (int dir = 0; dir < 4; dir++) {
                int ny = curY + dy[dir];
                int nx = curX + dx[dir];
                if (ny >= 0 && nx >= 0 && ny < 3 && nx < 3) {
                    int n = ny * 3 + nx; //움직인 곳의 좌표
                    char c = cur.charAt(n);

                    //0과 다음 위치의 자리 바꾸기
                    String next = cur.replace(c, 'c');
                    next = next.replace('0', c);
                    next = next.replace('c', '0');

                    if (!map.containsKey(next)) {
                        queue.add(next);
                        map.put(next, curMove + 1);
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder source = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                source.append(st.nextToken());
            }
        }

        map.put(source.toString(), 0);

        System.out.println(bfs(source.toString()));
    }

}
