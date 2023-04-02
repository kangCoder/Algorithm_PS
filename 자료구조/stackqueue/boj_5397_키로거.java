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
            //cursor를 기준으로 왼쪽은 prevStack, 오른쪽은 postStack에 넣게 만든다.
            //<가 나오면 cursor가 왼쪽으로 움직이니 prev에서 하나 꺼내서 post에 넣어준다.
            //다 끝났으면 prev에 남아있는걸 post에 다 옮기고 post를 출력하면 된다.
            //O(n)에 끝내야 함.
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
