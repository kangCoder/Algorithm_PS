package 자료구조.stackqueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class boj_5397_키로거 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            Stack<Character> prevStack = new Stack<>();
            Stack<Character> postStack = new Stack<>();

            char[] line = br.readLine().toCharArray();
            for (char c : line) {
                switch (c) {
                    case '<':
                        if (!prevStack.isEmpty()) {
                            postStack.push(prevStack.pop());
                        }
                        break;
                    case '>':
                        if (!postStack.isEmpty()) {
                            prevStack.push(postStack.pop());
                        }
                        break;
                    case '-':
                        if (!prevStack.isEmpty()) {
                            prevStack.pop();
                        }
                        break;
                    default:
                        prevStack.push(c);
                        break;
                }
            }

            while (!prevStack.isEmpty()) {
                postStack.push(prevStack.pop());
            }
            while (!postStack.isEmpty()) {
                bw.write(postStack.pop());
            }
            bw.write("\n");
        }
        bw.flush();
    }

}
