package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        long[] ans = new long[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long answer = Long.MAX_VALUE;
        for (int j = 0; j < n - 2; j++) {
            int i = j + 1, k = n-1;
            while (i < k) {
                long sum = arr[i] + arr[j] + arr[k];
                if (Math.abs(sum) < answer) {
                    answer = Math.abs(sum);
                    ans[0] = arr[j];
                    ans[1] = arr[i];
                    ans[2] = arr[k];
                }
                if (sum > 0) {
                    k--;
                } else {
                    i++;
                }
            }
        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
    }
}
