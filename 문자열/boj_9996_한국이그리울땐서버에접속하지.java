package 문자열;

import java.io.*;

public class boj_9996_한국이그리울땐서버에접속하지 {

    static int N;
    static String pattern;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        pattern = br.readLine();
        int star = pattern.indexOf('*');
        String start = pattern.substring(0, star);
        String end = pattern.substring(star + 1);

        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            if (file.startsWith(start) && file.endsWith(end)) {
                if (file.length() >= pattern.length() - 1) {
                    System.out.println("DA");
                } else {
                    System.out.println("NE");
                }
            } else {
                System.out.println("NE");
            }
        }
    }
}
