package simulation;

public class pro_k진수에서소수개수구하기 {

    private boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;

        String s = Integer.toString(n, k);
        String[] pNums = s.split("0");

        for (String num : pNums) {
            //
            if (num.equals("")) {
                continue;
            }

            long pn = Long.parseLong(num);
            if (isPrime(pn)) {
                answer++;
            }
        }
        return answer;
    }
}