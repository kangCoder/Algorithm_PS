package 삼성SW역량준비.simulation;

public class 배열나선탐색 {

    public static void main(String[] args) {
        int[][] testMap = new int[5][5];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int x = 2, y = 2, d = 0;
        int start = 1;
        testMap[x][y] = start;

        while (!(x == 0 && y == 0)) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            start++;
            testMap[nx][ny] = start;
            if (testMap[nx + dx[(d + 1) % 4]][ny + dy[(d + 1) % 4]] == 0) {
                d = (d + 1) % 4;
            }
            x = nx;
            y = ny;

            for (int[] t : testMap) {
                for (int i : t) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
