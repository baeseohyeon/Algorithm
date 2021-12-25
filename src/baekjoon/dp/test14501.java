package baekjoon.dp;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[][] arr = new int[2][n + 1];
        int[] dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = parseInt(st.nextToken());
            int p = parseInt(st.nextToken());
            arr[0][i] = t;
            arr[1][i] = p;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], ans);
            if (i - 1 + arr[0][i] <= n + 1) {
                dp[i - 1 + arr[0][i]] = Math.max(dp[i - 1 + arr[0][i]], dp[i - 1] + arr[1][i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }

}
