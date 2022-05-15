package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2212 { //https://maivve.tistory.com/293

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int k = parseInt(br.readLine());
        if (k >= n) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];
        int[] dp = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
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
