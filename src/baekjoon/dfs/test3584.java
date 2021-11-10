package baekjoon.dfs;

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class test3584 {
    static int n;
    static int ans;
    static int start, end;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            n = parseInt(br.readLine());
            list = new ArrayList[n + 1];
            visit = new boolean[n + 1];
            ans = 0;
            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < n - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = parseInt(st.nextToken());
                int b = parseInt(st.nextToken());
                list[b].add(a);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = parseInt(st.nextToken());
            end = parseInt(st.nextToken());
            dfs(start);
            dfs(end);
            bw.write(ans + "\n");
        }
        bw.flush();
    }

    private static void dfs(int now) {
        if (visit[now]) {
            ans = now;
            return;
        }
        visit[now] = true;
        for (int next : list[now]) {
            dfs(next);
        }
    }
}
