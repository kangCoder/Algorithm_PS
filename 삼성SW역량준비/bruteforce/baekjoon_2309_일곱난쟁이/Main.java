package 삼성SW역량준비.bruteforce.baekjoon_2309_일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int[] arr = new int[9];

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = sum;
                sum -= arr[i] + arr[j];
                if (sum == 100) {
                    arr[i] = arr[j] = 0;
                } else {
                    sum = tmp;
                }
            }
        }

        sort(arr);
        for (int i : arr) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }
}
