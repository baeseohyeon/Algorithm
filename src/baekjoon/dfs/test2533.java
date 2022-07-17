package baekjoon.dfs;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test2533 { //https://gre-eny.tistory.com/17

    static int n;
    static int[][] dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        dp = new int[n + 1][2];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1, 1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int now, int parent) {
        dp[now][0] = 0;
        dp[now][1] = 1;
        for (int next : list[now]) {
            if (next != parent) {
                dfs(next, now);
                dp[now][0] += dp[next][1];
                dp[now][1] += Math.min(dp[next][1], dp[next][0]);
            }
        }
    }
}
