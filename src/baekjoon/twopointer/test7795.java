package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test7795 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr1[i] = parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                arr2[i] = parseInt(st.nextToken());
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int ans = 0, j = 0;
            for (int i = 0; i < n; i++) {
                while (j < m && arr2[j] < arr1[i]) {
                    j++;
                }
                ans += j;
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
