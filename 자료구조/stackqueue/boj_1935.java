package 자료구조.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class boj_1935 {

    static Stack<Double> stack = new Stack<>();
    static Map<Character, Double> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();

        char key = 'A';
        for (int i = 0; i < N; i++) {
            double value = Integer.parseInt(br.readLine());
            map.put(key++, value);
        }

        for (int i = 0; i < line.length(); i++) {
            char target = line.charAt(i);
            if (map.containsKey(target)) {
                stack.push(map.get(target));
            } else if (stack.size() >= 2) {
                double a = stack.pop();
                double b = stack.pop();

                switch (target) {
                    case '+':
                        stack.push(b + a);
                        break;
                    case '-':
                        stack.push(b - a);
                        break;
                    case '*':
                        stack.push(b * a);
                        break;
                    case '/':
                        stack.push(b / a);
                        break;
                }
            }
        }

        System.out.printf("%.2f", stack.peek());
    }
}
