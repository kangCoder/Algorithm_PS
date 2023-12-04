package simulation;

import java.io.*;
import java.util.*;


public class boj_30620_서로소싫어 {

    static long x, y;

    //x -> x*y -> y
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        System.out.println(2);
        System.out.println(x * y - x);
        System.out.println(y - (x * y));
    }
}
