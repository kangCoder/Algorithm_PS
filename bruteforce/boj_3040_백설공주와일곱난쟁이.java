package bruteforce;

import java.io.*;

public class boj_3040_백설공주와일곱난쟁이 {

    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                for (int k = j + 1; k < 5; k++) {
                    for (int l = k + 1; l < 6; l++) {
                        for (int m = l + 1; m < 7; m++) {
                            for (int n = m + 1; n < 8; n++) {
                                for (int o = n + 1; o < 9; o++) {
                                    if (arr[i] + arr[j] + arr[k] + arr[l] + arr[m] + arr[n] + arr[o] == 100) {
                                        System.out.println(arr[i]);
                                        System.out.println(arr[j]);
                                        System.out.println(arr[k]);
                                        System.out.println(arr[l]);
                                        System.out.println(arr[m]);
                                        System.out.println(arr[n]);
                                        System.out.println(arr[o]);
                                        System.exit(0);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
