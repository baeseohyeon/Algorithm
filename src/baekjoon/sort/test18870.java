package baekjoon.sort;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = parseInt(st.nextToken());
            arr[i] = num;
        }
        int[] dp = Arrays.copyOf(arr, n);
        Arrays.sort(dp);
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = dp[i];
            if (map.containsKey(num)) {
                continue;
            }
            map.put(dp[i], cnt++);
        }
        for (int i = 0; i < n; i++) {
            bw.write(map.get(arr[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
