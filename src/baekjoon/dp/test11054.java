package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] dp2 = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = n; i >= 0; i--) {
            dp2[i] = 1;
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(dp[i] + dp2[i] - 1, ans);
        }
        System.out.println(ans);
    }

}
