package baekjoon.twopointer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14465 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int b = parseInt(st.nextToken());
        boolean[] lights = new boolean[n + 1];
        for (int i = 0; i < b; i++) {
            int m = parseInt(br.readLine());
            lights[m] = true;
        }
        int cnt = 0;
        for (int i = 1; i <= k; i++) {
            if (lights[i]) {
                cnt++;
            }
        }
        int ans = cnt;
        for (int i = k + 1; i <= n; i++) {
            if (lights[i - k]) {
                cnt--;
            }
            if (lights[i]) {
                cnt++;
            }
            ans = Math.min(ans, cnt);
        }
        System.out.println(ans);
    }

}
