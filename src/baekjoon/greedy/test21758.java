package baekjoon.greedy;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test21758 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + arr[i];
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int b1 = dp[n - 1] - arr[i] - arr[0];
            int b2 = dp[n - 1] - dp[i];
            ans = Math.max(b1 + b2, ans);
        }
        for (int i = 1; i < n - 1; i++) {
            int b1 = dp[n - 1] - arr[i] - arr[n - 1];
            int b2 = dp[i - 1];
            ans = Math.max(b1 + b2, ans);
        }
        for (int i = 1; i < n - 1; i++) {
            int b1 = dp[i] - arr[0];
            int b2 = dp[n - 1] - dp[i - 1] - arr[n - 1];
            ans = Math.max(b1 + b2, ans);
        }
        System.out.println(ans);
    }
}
