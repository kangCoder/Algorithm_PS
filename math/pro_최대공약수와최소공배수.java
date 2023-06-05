package math;

public class pro_최대공약수와최소공배수 {

    private int findGCD(int n, int m) {
        while (m != 0) {
            int tmp = m;
            m = n % m;
            n = tmp;
        }

        return n;
    }

    private int findLCM(int n, int m) {
        return (n * m) / findGCD(n, m);
    }

    public int[] solution(int n, int m) {
        return new int[]{findGCD(n, m), findLCM(n, m)};
    }
}