package baekjoon.greedy;

import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class test1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(br.readLine());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int sum = 0, i, j;
        for (i = 0; i < n && arr[i] > 0; i++) {
            if (i < n - 1 && arr[i] * arr[i + 1] > arr[i] + arr[i + 1]) {
                sum += arr[i] * arr[i + 1];
                i++;
            } else {
                sum += arr[i];
            }
        }
        for (j = n - 1; j >= i && arr[j] < 0; j--) {
            if (j > 0 && arr[j] * arr[j - 1] > arr[j] + arr[j - 1]) {
                sum += arr[j] * arr[j - 1];
                j--;
            } else {
                sum += arr[j];
            }
        }
        System.out.println(sum);
    }

}
