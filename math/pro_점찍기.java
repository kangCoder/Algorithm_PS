package math;

public class pro_점찍기 {

    public long solution(int k, int d) {
        long answer = 0; //(0, 0)

        for (int x = 0; x <= d; x += k) {
            double maxY = Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            int i = maxY % k == 0 ? 1 : 0;
            answer += Math.ceil(maxY / k) + i;
        }

        return answer;
    }
}