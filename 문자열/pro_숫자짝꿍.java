package 문자열;

public class pro_숫자짝꿍 {

    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();

        int[] numbersX = new int[10];
        int[] numbersY = new int[20];

        for (int i = 0; i < X.length(); i++) {
            int j = Character.getNumericValue(X.charAt(i));
            numbersX[j]++;
        }

        for (int i = 0; i < Y.length(); i++) {
            int j = Character.getNumericValue(Y.charAt(i));
            numbersY[j]++;
        }

        boolean flag = false;
        for (int i = 9; i >= 0; i--) {
            while (numbersX[i] > 0 && numbersY[i] > 0) {
                flag = true;
                sb.append(i);
                numbersX[i]--;
                numbersY[i]--;
            }
        }

        if (!flag) {
            return "-1";
        }

        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }

        return answer;
    }
}
