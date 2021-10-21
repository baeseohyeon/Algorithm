package baekjoon.graphtheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.*;

public class test1167 {

    static int n;
    static int ans = 0;
    static int vertex = 0;
    static boolean[] visit;
    static List<Node>[] list;

    static class Node {
        int v, e;

        Node(int v, int e) {
            this.v = v;
            this.e = e;
        }
    }

    public static void solve(int now, int cnt) {
        visit[now] = true;
        if(ans < cnt){
            ans = cnt;
            vertex = now;
        }
        for (Node node : list[now]) {
            int next = node.v;
            if (!visit[next]) {
                solve(next, cnt + node.e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        visit = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = parseInt(st.nextToken());
            int v = 0;
            while ((v = parseInt(st.nextToken())) != -1) {
                int e = parseInt(st.nextToken());
                list[now].add(new Node(v, e));
            }
        }
        solve(1,0);
        visit = new boolean[n+1];
        solve(vertex, 0);
        System.out.println(ans);
    }
}
