package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class test14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0, j = n - 1, num = MAX_VALUE;
        while (i < j) {
            int sum = arr[i] + arr[j];
            int absSum = Math.abs(sum);
            if (Math.abs(num) > absSum) {
                num = sum;
            }
            if (sum > 0) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println(num);
    }
}
