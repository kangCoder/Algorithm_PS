package simulation;

public class pro_혼자서하는틱택토 {

    private boolean checkThree(char[][] boards, char c) {
        //가로 check
        for (int i = 0; i < 3; i++) {
            if (boards[i][0] == c && boards[i][1] == c && boards[i][2] == c) {
                return true;
            }
        }

        //세로 check
        for (int i = 0; i < 3; i++) {
            if (boards[0][i] == c && boards[1][i] == c && boards[2][i] == c) {
                return true;
            }
        }

        //대각선 check
        if (boards[0][0] == c && boards[1][1] == c && boards[2][2] == c) {
            return true;
        }
        if (boards[0][2] == c && boards[1][1] == c && boards[2][0] == c) {
            return true;
        }

        return false;
    }

    public int solution(String[] board) {
        int answer = -1;

        int cntO = 0, cntX = 0;
        char[][] boards = new char[board.length][board[0].length()];
        for (int i = 0; i < boards.length; i++) {
            for (int j = 0; j < boards[i].length; j++) {
                boards[i][j] = board[i].charAt(j);
                if (boards[i][j] == 'O') {
                    cntO++;
                } else if (boards[i][j] == 'X') {
                    cntX++;
                }
            }
        }

        //1. X가 O보다 많으면 실수.
        //2. O랑 X의 개수가 같을 때, O가 승리한 상태면 실수.
        //3. O가 X보다 개수가 많을 때, 둘의 차이가 2 이상이면 실수.
        //4. O가 X보다 개수가 많을 때, X가 이긴 상태면 실수.

        if (cntO < cntX || Math.abs(cntO - cntX) >= 2) {
            //1. X가 O보다 많거나, O와 X의 개수 차이가 2개 이상이면 실수
            answer = 0;
        } else if (cntO == cntX) {
            //2. O가 X랑 O가 3개 이상이면서 같은데, O가 연속 3줄이면 실수
            if (cntO >= 3) {
                if (checkThree(boards, 'O')) {
                    answer = 0;
                } else {
                    answer = 1;
                }
            } else {
                answer = 1;
            }
        } else {
            //3. O가 X보다 많을 때, X가 승리한 상태면 실수.
            if (cntO >= 3) {
                if (checkThree(boards, 'X')) {
                    answer = 0;
                } else {
                    answer = 1;
                }
            } else {
                answer = 1;
            }
        }

        return answer;
    }
}