package 문자열;

public class pro_둘만의암호 {

    public String solution(String s, String skip, int index) {
        String answer = "";
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < skip.length(); i++) {
            alphabets = alphabets.replace(Character.toString(skip.charAt(i)), "");
        }

        for (int i = 0; i < s.length(); i++) {
            int idx = (alphabets.indexOf(Character.toString(s.charAt(i))) + index) % alphabets.length();
            answer += Character.toString(alphabets.charAt(idx));
        }

        return answer;
    }
}
