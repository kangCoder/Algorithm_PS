package 자료구조.stackqueue;

import java.util.*;

public class pro_택배상자 {

    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        for (int i = 1; i <= order.length; i++) {
            boolean check = false;

            if (order[idx] == i) {
                answer++;
                idx++;
                check = true;
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
                check = true;
            }

            if (!check) {
                stack.push(i);
            }
        }

        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            answer++;
            idx++;
        }

        return answer;
    }
}