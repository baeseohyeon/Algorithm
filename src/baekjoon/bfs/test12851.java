package baekjoon.bfs;

import java.util.*;

public class test12851 {
    static int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int time = MAX + 1, cnt = 0;
        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, MAX);
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        dp[n] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k) {
                if (dp[now] == time) {
                    cnt++;
                } else if (dp[now] < time) {
                    cnt = 1;
                    time = dp[now];
                }
                continue;
            }
            int next = now * 2;
            if (next <= MAX && dp[next] >= dp[now] + 1) {
                q.add(next);
                dp[next] = dp[now] + 1;
            }
            next = now - 1;
            if (next >= 0 && dp[next] >= dp[now] + 1) {
                q.add(next);
                dp[next] = dp[now] + 1;
            }
            next = now + 1;
            if (next <= MAX && dp[next] >= dp[now] + 1) {
                q.add(next);
                dp[next] = dp[now] + 1;
            }
        }
        System.out.println(time + "\n" + cnt);
    }
}
