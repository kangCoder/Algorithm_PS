package dfsbfs;

import java.util.*;

public class pro_단어변환 {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        boolean[] visited = new boolean[words.length];

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (target.equals(cur.word)) {
                answer = cur.cnt;
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i]) {
                    int notMatch = 0;
                    for (int j = 0; j < words[i].length(); j++) {
                        if (cur.word.charAt(j) != words[i].charAt(j)) {
                            notMatch++;
                        }
                    }

                    if (notMatch == 1) {
                        visited[i] = true;
                        queue.offer(new Node(words[i], cur.cnt + 1));
                    }
                }
            }
        }

        return answer;
    }

    static class Node {

        String word;
        int cnt;

        public Node(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}
