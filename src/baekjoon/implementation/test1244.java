package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test1244 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[] switches = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = parseInt(st.nextToken());
        }
        int t = parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = parseInt(st.nextToken());
            int num = parseInt(st.nextToken());
            if (gender == 1) {
                for (int i = 1; num * i <= n; i++) {
                    switches[num * i] = switches[num * i] == 1 ? 0 : 1;
                }
            } else {
                int k = 1;
                while (num - k >= 1 && num + k <= n) {
                    if (switches[num - k] != switches[num + k]) {
                        break;
                    }
                    k++;
                }
                k--;
                for (int i = num - k; i < num; i++) {
                    switches[i] = switches[i] == 1 ? 0 : 1;
                }
                for (int i = num + k; i >= num; i--) {
                    switches[i] = switches[i] == 1 ? 0 : 1;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
