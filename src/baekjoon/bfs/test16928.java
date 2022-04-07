package baekjoon.bfs;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test16928 {

    static int n, m, ans = MAX_VALUE;
    static int[] map;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[101];
        dp = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            map[a] = b;
        }
        Arrays.fill(dp, MAX_VALUE);
        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        dp[1] = 0;
        q.add(1);
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == 100) {
                ans = dp[now];
                return;
            }
            if (map[now] != 0) {
                dp[map[now]] = dp[now];
                q.add(map[now]);
            } else {
                for (int i = 1; now + i <= 100 && i <= 6; i++) {
                    int next = now + i;
                    if (dp[next] > dp[now]) {
                        dp[next] = dp[now] + 1;
                        q.add(next);
                    }
                }
            }
        }
    }
}
