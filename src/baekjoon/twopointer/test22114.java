package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test22114 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int i = 1, cnt = 0, ans = 2, jump =0;
        for (int j = 2; j <= n; j++) {
            if (arr[j] > k) {
                cnt++;
                if (cnt > 1) {
                    i = jump;
                }
                jump = j;
            }
            ans = Math.max(j - i + 1, ans);
        }
        System.out.println(ans);
    }
}
