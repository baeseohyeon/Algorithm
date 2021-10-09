package baekjoon.twopointer;

import java.io.*;
import java.util.Arrays;

import static java.lang.Integer.*;

public class test3649 {
    static int leftNum = 0, rightNum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        while ((str = br.readLine()) != null) {
            boolean flag = false;
            int x = parseInt(str);
            int n = parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = parseInt(br.readLine());
            }
            x = (int) (x * Math.pow(10, 7));
            Arrays.sort(arr);
            int i = 0, j = n - 1;
            while (i < j) {
                if (arr[i] + arr[j] == x) {
                    flag = true;
                    leftNum = arr[i];
                    rightNum = arr[j];
                    break;
                }
                if (arr[i] + arr[j] > x) {
                    j--;
                } else {
                    i++;
                }
            }

            if (flag) {
                bw.write("yes " + leftNum + " " + rightNum + "\n");
            } else {
                bw.write("danger\n");
            }
        }
        bw.flush();
    }


}
