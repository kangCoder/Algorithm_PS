package 문자열;

import java.util.*;
import java.util.regex.*;

public class pro_다트게임 {

    public int solution(String dartResult) {
        int answer = 0;

        Pattern p = Pattern.compile("([0-9]+)([SDT])([*#]?)");
        Matcher m = p.matcher(dartResult);

        Stack<Integer> stack = new Stack<>();
        while (m.find()) {
            int num = Integer.parseInt(m.group(1));

            switch (m.group(2)) {
                case "D":
                    num *= num;
                    break;
                case "T":
                    num *= num * num;
                default:
                    break;
            }

            switch (m.group(3)) {
                case "*":
                    if (!stack.isEmpty()) {
                        stack.push(stack.pop() * 2);
                    }
                    num *= 2;
                    break;
                case "#":
                    num *= -1;
                    break;
            }

            stack.push(num);
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}