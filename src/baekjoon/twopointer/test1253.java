package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class test1253 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int left = 0, right = n - 1;
            while (left < right) {
                if (left == i)
                    left++;
                if (right == i)
                    right--;
                if (left >= right) {
                    break;
                }
                int sum = arr[left] + arr[right];
                if (sum == num) {
                    cnt++;
                    break;
                } else if (sum > num) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        System.out.println(cnt);
    }
}
