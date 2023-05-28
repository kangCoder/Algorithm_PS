package greedy;

public class pro_기지국설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        int start = 1;
        int curStation = 0;
        while (start <= n) {
            //start가 현재 기지국의 범위 안에 든다면 start를 그냥 갱신
            if (curStation < stations.length && start >= stations[curStation] - w) {
                start = stations[curStation] + w + 1;
                curStation++;
            } else {
                //그게 아니라면 기지국을 세워줘야 함.
                answer++;
                start += 2 * w + 1; //양방향으로 전파되는 것이기 때문에 2 * w하고 그 다음 위치인 + 1.
            }
        }

        return answer;
    }
}
