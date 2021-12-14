package baekjoon.twopointer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int i = 0, j = n - 1, minNum = MAX_VALUE;
        int[] ans = new int[2];
        while (i < j) {
            int num = Math.abs(arr[i] + arr[j]);
            if (minNum >= num) {
                minNum = num;
                ans[0] = arr[i];
                ans[1] = arr[j];
            }
            if (Math.abs(arr[i]) < Math.abs(arr[j])) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }

}
