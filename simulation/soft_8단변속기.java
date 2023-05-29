package simulation;

import java.util.*;
import java.io.*;

public class soft_8단변속기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int flag = 0; //1: ascending, 2: descending, 3: mixed
        if (arr[0] < arr[1]) {
            flag = 1;
        } else if (arr[0] > arr[1]) {
            flag = 2;
        }

        for (int i = 1; i < 8; i++) {
            if (flag == 1 && arr[i - 1] > arr[i]) {
                flag = 3;
            }
            if (flag == 2 && arr[i - 1] < arr[i]) {
                flag = 3;
            }
        }

        if (flag == 1) {
            System.out.println("ascending");
        } else if (flag == 2) {
            System.out.println("descending");
        } else if (flag == 3) {
            System.out.println("mixed");
        }
    }
}
