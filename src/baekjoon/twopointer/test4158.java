package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test4158 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }
            int[] arr = new int[n];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr[i] = parseInt(br.readLine());
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = parseInt(br.readLine());
            }
            int i = 0, j = 0, ans = 0;
            while (i < n && j < m) {
                if (arr[i] == arr2[j]) {
                    ans++;
                    i++;
                    j++;
                } else if (arr[i] < arr2[j]) {
                    i++;
                } else {
                    j++;
                }
            }
            System.out.println(ans);
        }
    }

}
