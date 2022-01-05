package baekjoon.dp;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int[] coins = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coins[i] = parseInt(br.readLine());
        }
        for (int i = coins[0]; i <= k; i += coins[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int coin = coins[i];
            if (coin <= k) {
                dp[coin]++;
            }
            for (int j = coin; j <= k; j++) {
                dp[j] = dp[j - coin] + dp[j];
            }
        }
        System.out.println(dp[k]);
    }

}
