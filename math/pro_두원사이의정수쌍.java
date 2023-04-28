package math;

public class pro_두원사이의정수쌍 {

    //x^2 + y^2 = r^2
    private int getY2(long x, long r) {
        return (int) Math.sqrt(r * r - x * x);
    }

    //r1에 딱 걸치는 좌표도 포함시켜야 하기 때문에...
    private int getY1(long x, long r) {
        double max = Math.sqrt(r * r - x * x);
        if (max == (int) max) {
            return (int) max - 1;
        } else {
            return (int) max;
        }
    }

    public long solution(long r1, long r2) {
        long answer = 0;

        for (int i = 1; i < r2; i++) {
            if (i >= r1) {
                answer += getY2(i, r2);
            } else {
                answer += (getY2(i, r2) - getY1(i, r1));
            }
        }

        answer *= 4;
        answer += (r2 - r1 + 1) * 4; //축에 있는 애들도 포함시키기
        return answer;
    }
}
