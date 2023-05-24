package simulation;

public class pro_비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            String bin1 = Integer.toBinaryString(arr1[i]);
            String bin2 = Integer.toBinaryString(arr2[i]);
            while (bin1.length() < n) {
                bin1 = "0" + bin1;
            }
            while (bin2.length() < n) {
                bin2 = "0" + bin2;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bin1.length(); j++) {
                char c1 = bin1.charAt(j);
                char c2 = bin2.charAt(j);

                if (c1 == '1' || c2 == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

}
