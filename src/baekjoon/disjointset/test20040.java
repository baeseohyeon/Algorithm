package baekjoon.disjointset;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test20040 {

    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            a = find(a);
            b = find(b);
            if (a == b) {
                System.out.println(i + 1);
                return;
            }
            if (a > b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
        System.out.println(0);
    }

    private static int find(int now) {
        if (now == parent[now]) {
            return now;
        }
        return parent[now] = find(parent[now]);
    }
}
