package baekjoon.dfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test15681 {

    static int n, r, q, cnt;
    static int[] dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        r = parseInt(st.nextToken());
        q = parseInt(st.nextToken());
        dp = new int[100001];
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(r);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < q; i++) {
            cnt = 0;
            int u = parseInt(br.readLine());
            sb.append(dp[u] + "\n");
        }
        System.out.println(sb);
    }

    private static int dfs(int now) {
        dp[now]++;
        for (int next : list[now]) {
            if (dp[next] == 0) {
                dp[now] += dfs(next);
            }
        }
        return dp[now];
    }
}
