package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test13422 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            int k = parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = parseInt(st.nextToken());
            }
            int sum = 0, ans = 0;
            for (int i = 0; i < m; i++) {
                sum += arr[i];
            }
            int i = 0, j = m;
            if (n == m) {
                if (sum < k)
                    System.out.println(1);
                else
                    System.out.println(0);
                continue;
            }
            while (i < n) {
                if (sum < k) {
                    ans++;
                }
                sum += arr[j % n];
                sum -= arr[i++];
                j++;
            }
            System.out.println(ans);
        }
    }
}
