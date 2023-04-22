package simulation;

public class pro_공원산책 {

    public int[] solution(String[] park, String[] routes) {
        String[][] parks = new String[park.length][park[0].length()];
        for (int i = 0; i < parks.length; i++) {
            for (int j = 0; j < parks[i].length; j++) {
                String[] s = park[i].split("");
                parks[i][j] = s[j];
            }
        }

        int[] answer = new int[2];
        int MAX_ROW = parks.length - 1;
        int MAX_COL = parks[0].length - 1;
        int row = -1, col = -1;

        for (int i = 0; i < parks.length; i++) {
            for (int j = 0; j < parks[i].length; j++) {
                if (parks[i][j].equals("S")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");

            String op = s[0];
            int n = Integer.parseInt(s[1]);

            boolean flag = false;
            switch (op) {
                case "N":
                    for (int dir = 1; dir <= n; dir++) {
                        int nr = row - dir;
                        if (nr < 0 || parks[nr][col].equals("X")) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        row -= n;
                    }
                    break;
                case "S":
                    for (int dir = 1; dir <= n; dir++) {
                        int nr = row + dir;
                        if (nr > MAX_ROW || parks[nr][col].equals("X")) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        row += n;
                    }
                    break;
                case "W":
                    for (int dir = 1; dir <= n; dir++) {
                        int nc = col - dir;
                        if (nc < 0 || parks[row][nc].equals("X")) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        col -= n;
                    }
                    break;
                case "E":
                    for (int dir = 1; dir <= n; dir++) {
                        int nc = col + dir;
                        if (nc > MAX_COL || parks[row][nc].equals("X")) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        col += n;
                    }
                    break;
            }
        }

        answer[0] = row;
        answer[1] = col;
        return answer;
    }

}
