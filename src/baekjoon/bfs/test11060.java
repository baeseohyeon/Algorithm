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

public class test11060 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] dp = new int[100001];
        int[] arr = new int[n + 1];
        Arrays.fill(dp, MAX_VALUE);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        if (n == 1) {
            System.out.println(0);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dp[1] = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i <= arr[now]; i++) {
                if (now + i >= n) {
                    System.out.println(dp[now] + 1);
                    return;
                }
                if (dp[now + i] > dp[now] + 1) {
                    dp[now + i] = dp[now] + 1;
                    q.add(now + i);
                }
            }
        }
        System.out.println(-1);
    }
}
