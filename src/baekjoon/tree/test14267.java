package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test14267 {

    static int n, m;
    static List<Integer>[] list;
    static int[] dp;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dp = new int[n + 1];
        sb = new StringBuffer();
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 2; i <= n; i++) {
            int boss = parseInt(st.nextToken());
            list[boss].add(i);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = parseInt(st.nextToken());
            int cnt = parseInt(st.nextToken());
            dp[num] += cnt;
        }
        dfs(1);
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i] + " ");
        }
        System.out.println(sb);
    }

    private static void dfs(int now) {
        for (int next : list[now]) {
            dp[next] += dp[now];
            dfs(next);
        }
    }
}
