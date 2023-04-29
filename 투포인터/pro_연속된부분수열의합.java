package 투포인터;

import java.util.*;

public class pro_연속된부분수열의합 {

    public int[] solution(int[] sequence, int k) {
        ArrayList<Element> subSequences = new ArrayList<>();

        int sum = sequence[0];
        int left = 0, right = 0;
        while (true) {
            if (sum == k) {
                subSequences.add(new Element(left, right));
            }

            if (left == sequence.length && right == sequence.length) {
                break;
            }

            if (sum <= k && right < sequence.length) {
                right++;

                if (right < sequence.length) {
                    sum += sequence[right];
                }
            } else {
                if (left < sequence.length) {
                    sum -= sequence[left];
                }

                left++;
            }
        }

        subSequences.sort(Element::compareTo);
        return new int[]{subSequences.get(0).left, subSequences.get(0).right};
    }

    class Element implements Comparable<Element> {

        int left, right;
        int size;

        public Element(int left, int right) {
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        //오름차순 정렬
        @Override
        public int compareTo(Element e) {
            if (this.size == e.size) {
                return this.left - e.left;
            } else {
                return this.size - e.size;
            }
        }
    }
}
