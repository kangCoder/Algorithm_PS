package 문자열;

public class pro_문자열나누기 {

    public int solution(String s) {
        int answer = 0;

        int idx = 0;
        while (idx < s.length()) {
            if (idx == s.length() - 1) {
                answer++;
                break;
            }

            char cur = s.charAt(idx);
            int equalCur = 1;
            int notEqualCur = 0;

            int i = 0;
            for (i = idx + 1; i < s.length(); i++) {
                if (cur == s.charAt(i)) {
                    equalCur++;
                } else {
                    notEqualCur++;
                }

                if (equalCur == notEqualCur) {
                    answer++;
                    break;
                }
            }

            if (notEqualCur == 0) {
                answer++;
                break;
            }

            if (equalCur != notEqualCur && i == s.length()) {
                answer++;
                break;
            }

            idx = i + 1;
        }

        return answer;
    }

}
