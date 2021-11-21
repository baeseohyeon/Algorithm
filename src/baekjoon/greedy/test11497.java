package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class test11497 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(arr);
            int ans = Math.abs(arr[0] - arr[1]);
            for(int i=0; i<n-2; i++){
                ans = Math.max(ans, Math.abs(arr[i] - arr[i + 2]));
            }
            bw.write(ans + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
