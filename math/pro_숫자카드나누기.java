package math;

import java.util.*;

public class pro_숫자카드나누기 {

    private int findGCD(int n, int m) {
        if (m == 0) {
            return n;
        } else {
            return findGCD(m, n % m);
        }
    }

    private boolean checkDivide(int n, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % n == 0) {
                return true;
            }
        }

        return false;
    }

    public int solution(int[] arrayA, int[] arrayB) {
        //A에 대한 최대공약수
        int gcdA = arrayA[0];
        if (arrayA.length > 1) {
            for (int i = 1; i < arrayA.length; i++) {
                gcdA = findGCD(gcdA, arrayA[i]);
            }
        }

        //a부터 시작해서 a의 약수들에 대해서도 확인해야함.
        List<Integer> listA = new ArrayList<>(); //arrayA의 공약수들
        for (int i = 1; i <= gcdA; i++) {
            if (gcdA % i == 0) {
                listA.add(i);
            }
        }

        int answerA = 0;
        for (int i = listA.size() - 1; i >= 0; i--) {
            if (!checkDivide(listA.get(i), arrayB)) {
                answerA = listA.get(i);
                break;
            }
        }

        //B에 대한 최대공약수
        int gcdB = arrayB[0];
        if (arrayB.length > 1) {
            for (int i = 1; i < arrayB.length; i++) {
                gcdB = findGCD(gcdB, arrayB[i]);
            }
        }

        List<Integer> listB = new ArrayList<>(); //arrayB의 공약수들
        for (int i = 1; i <= gcdB; i++) {
            if (gcdB % i == 0) {
                listB.add(i);
            }
        }

        int answerB = 0;
        for (int i = listB.size() - 1; i >= 0; i--) {
            if (!checkDivide(listB.get(i), arrayA)) {
                answerB = listB.get(i);
                break;
            }
        }

        if (answerA == 0 && answerB == 0) {
            return 0;
        }

        return Math.max(answerA, answerB);
    }
}