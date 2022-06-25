package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test1240 {

    static int n, m;
    static List<Node>[] list;
    static StringBuffer sb;
    static boolean[] visit;

    static class Node {

        int next, distance;

        Node(int next, int distance) {
            this.next = next;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        sb = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int c = parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            visit = new boolean[n + 1];
            dfs(a, b, 0);
        }
        System.out.println(sb);
    }

    private static void dfs(int now, int end, int cnt) {
        visit[now] = true;
        if (now == end) {
            sb.append(cnt + "\n");
            return;
        }
        for (Node node : list[now]) {
            if (!visit[node.next]) {
                dfs(node.next, end, cnt + node.distance);
            }
        }
    }
}
