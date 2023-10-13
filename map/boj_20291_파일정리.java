package map;

import java.util.*;
import java.io.*;

public class boj_20291_파일정리 {

    static int N;
    static Map<String, Integer> fileMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String file = br.readLine();
            int idx = file.indexOf(".");

            String extension = file.substring(idx + 1);
            fileMap.put(extension, fileMap.getOrDefault(extension, 0) + 1);
        }

        List<String> fileList = new ArrayList<>(fileMap.keySet());
        fileList.sort(String::compareTo);
        for (String file : fileList) {
            System.out.println(file + " " + fileMap.get(file));
        }
    }
}
