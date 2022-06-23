package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test11437 {

    static int[] depth;
    static int[] parent;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        depth = new int[n + 1];
        parent = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        setParent(0, 1, 1);
        StringBuffer sb = new StringBuffer();
        int m = parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            sb.append(LCS(a, b) + "\n");
        }
        System.out.println(sb);
    }

    public static void setParent(int cnt, int now, int prev) {
        parent[now] = prev;
        depth[now] = cnt;
        for (int next : list[now]) {
            if (parent[next] == 0) {
                setParent(cnt + 1, next, now);
            }
        }
    }

    public static int LCS(int a, int b) {
        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}
