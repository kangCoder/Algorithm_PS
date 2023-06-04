package greedy;

import java.util.*;

public class pro_뒤에있는큰수찾기 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> s = new Stack<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            //i번째 수가 스택의 값보다 작아질 때까지 스택의 값을 꺼낸다.
            while (!s.isEmpty() && s.peek() <= numbers[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = s.peek();
            }

            s.push(numbers[i]);
        }

        return answer;
    }
}