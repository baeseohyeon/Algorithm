package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test15565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int i = 0, j = 0, ans = MAX_VALUE;
        int[] friends = new int[3];
        while (true) {
            if (friends[1] >= k) {
                ans = Math.min(ans, j - i);
                friends[arr[i++]]--;
            } else if (j == n) {
                break;
            } else {
                friends[arr[j++]]++;
            }
        }
        if (ans == MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);

    }
}
