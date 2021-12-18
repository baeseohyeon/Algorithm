package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2118 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(br.readLine());
        }
        int[] sum = new int[n + 1];
        sum[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        int i = 0, j = 1, ans = 0;
        while (i <= j && j <= n) {
            int clock = sum[n] - sum[j] + sum[i];
            int reverse = sum[j] - sum[i];
            int num = Math.min(clock, reverse);
            ans = Math.max(ans, num);
            if (reverse == num) {
                j++;
            } else {
                i++;
            }
        }
        System.out.println(ans);
    }

}
