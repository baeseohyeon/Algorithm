package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class test1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(br.readLine());
            arr[i]++;
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            ans += Math.max(arr[i] - (n - i), 0);
        }
        System.out.println(ans);
    }
}
