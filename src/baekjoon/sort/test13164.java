package baekjoon.sort;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test13164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int[] dp = new int[n - 1];
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            dp[i] = arr[i + 1] - arr[i];
        }
        Arrays.sort(dp);
        int sum = 0;
        for (int i = 0; i < n - k; i++) {
            sum += dp[i];
        }
        System.out.println(sum);
    }
}
