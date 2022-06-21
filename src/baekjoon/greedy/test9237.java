package baekjoon.greedy;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class test9237 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            arr[i] += (i + 1);
            ans = Math.max(ans, arr[i]);
        }
        System.out.println(ans + 1);
    }
}
