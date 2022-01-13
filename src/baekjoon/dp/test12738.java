package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test12738 {

    static int dp[];
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        dp[1] = arr[1];
        int idx = 1, ans = 1;
        for (int i = 2; i <= n; i++) {
            if (dp[idx] < arr[i]) {
                dp[++idx] = arr[i];
                ans++;
            } else {
                int k = binarySearch(idx, arr[i]);
                dp[k] = arr[i];
            }
        }
        System.out.println(ans);

    }

    private static int binarySearch(int right, int target) {
        int left = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
