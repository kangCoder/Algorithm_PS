package simulation;

public class pro_바탕화면정리 {

    public int[] solution(String[] wallpaper) {
        char[][] map = new char[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = wallpaper[i].charAt(j);
            }
        }

        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;

        //왼쪽 위부터 훑기
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                }
            }
        }

        //오른쪽 아래부터 훑기
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = map[i].length - 1; j >= 0; j--) {
                if (map[i][j] == '#') {
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }

        return new int[]{lux, luy, rdx, rdy};
    }

}
