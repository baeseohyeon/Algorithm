package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test10025 { //https://www.acmicpc.net/source/15311548 참고


    static int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int[] buckets = new int[MAX + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ice = parseInt(st.nextToken());
            int idx = parseInt(st.nextToken());
            buckets[idx] = ice;
        }
        k = k * 2 + 1;
        int sum = 0, ans = 0;
        for (int i = 0; i <= MAX; i++) {
            if (i >= k) {
                sum -= buckets[i - k];
            }
            sum += buckets[i];
            ans = Math.max(sum, ans);
        }
        System.out.println(ans);
    }

}
