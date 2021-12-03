package baekjoon.twopointer;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = parseInt(s[0]);
        int d = parseInt(s[1]);
        int k = parseInt(s[2]);
        int c = parseInt(s[3]);
        int[] arr = new int[n];
        int[] sushi = new int[d + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(br.readLine());
        }
        int i = 0, j = 0;
        int ans = 0, cnt = 0;
        while (i < n) {
            sushi[arr[j]]++;
            if (sushi[arr[j]] == 1) {
                cnt++;
            }
            j = j + 1 >= n ? 0 : j + 1;
            if (j - i == k || n - i + j == k) {
                if (sushi[c] == 0) {
                    ans = Math.max(ans, cnt + 1);
                } else {
                    ans = Math.max(ans, cnt);
                }
                sushi[arr[i]]--;
                if (sushi[arr[i]] == 0) {
                    cnt--;
                }
                i++;
            }
        }
        System.out.println(ans);
    }
}

