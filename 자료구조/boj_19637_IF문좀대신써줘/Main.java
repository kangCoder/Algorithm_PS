package 자료구조.boj_19637_IF문좀대신써줘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N, M; //N: 칭호의 개수, M: 캐릭터의 개수
    public static String[] titleName;
    public static int[] titleUpperLimit;

    public static int upperBound(int target) {
        int start = 0, end = titleUpperLimit.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (titleUpperLimit[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        titleName = new String[N];
        titleUpperLimit = new int[N];
        for (int i = 0; i < titleName.length; i++) {
            st = new StringTokenizer(br.readLine());
            titleName[i] = st.nextToken();
            titleUpperLimit[i] = Integer.parseInt(
                    st.nextToken()); //전투력 상한값은 비내림차순으로 주어지기 때문에 따로 정렬시킬 필요 없음
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(titleName[upperBound(Integer.parseInt(br.readLine()))]+"\n");
        }
        System.out.println(sb);
    }
}