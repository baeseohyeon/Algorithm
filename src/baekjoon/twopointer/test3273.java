package baekjoon.twopointer;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test3273 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0, j = n - 1, cnt = 0;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum > x) {
                j--;
            } else if (sum < x) {
                i++;
            } else {
                cnt++;
                j--;
                i++;
            }
        }
        System.out.println(cnt);
    }
}
