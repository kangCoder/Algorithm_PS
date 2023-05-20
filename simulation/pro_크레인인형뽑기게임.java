package simulation;

import java.util.*;

public class pro_크레인인형뽑기게임 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                if (board[j][move] == 0) {
                    continue;
                }

                //System.out.println("크레인 위치: " + move + ", 인형: " + board[j][move]);
                if (stack.isEmpty()) {
                    stack.push(board[j][move]);
                    board[j][move] = 0;
                    break;
                } else if (stack.peek() == board[j][move]) {
                    stack.pop();
                    answer += 2;
                    board[j][move] = 0;
                    break;
                } else {
                    stack.push(board[j][move]);
                    board[j][move] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}