package graph;

public class UnionFind기본 {

    static int[] parent;

    //a와 b를 하나의 집합으로 합친다.
    static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    //a와 b가 같은 그래프에 속해있는지 판별한다.
    static boolean find(int a, int b) {
        return getParent(a) == getParent(b);
    }

    //x의 부모를 반환한다.
    static int getParent(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent[x]);
    }

    public static void main(String[] args) {
        parent = new int[11];
        for (int i = 1; i <= 10; i++) {
            parent[i] = i; //일단 자기 자신을 가리키도록 한다.
        }

        //1-2-3, 4-5-6-7이 같은 그래프.
        union(1, 2);
        union(2, 3);
        union(3, 4);
        union(5, 6);
        union(4, 7);

        System.out.println("1과 3은 같은 그래프? " + find(1, 3));
        System.out.println("1과 4은 같은 그래프? " + find(1, 4));
        System.out.println("4과 5은 같은 그래프? " + find(4, 5));
        System.out.println("5과 7은 같은 그래프? " + find(5, 7));

        System.out.println("1과 5은 같은 그래프? " + find(1, 5));
        union(1, 5);
        System.out.println("5과 7은 같은 그래프? " + find(1, 5));

    }
}
