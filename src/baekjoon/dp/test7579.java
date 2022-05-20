package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test7579 {

    static class App {

        int memory, price;

        App(int memory, int price) {
            this.memory = memory;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        App[] apps = new App[n];
        for (int i = 0; i < n; i++) {
            apps[i] = new App(parseInt(st.nextToken()), parseInt(st2.nextToken()));
        }
        int[] dp = new int[10001];
        for (int i = 0; i < n; i++) {
            int price = apps[i].price;
            int memory = apps[i].memory;
            for (int j = 10000; j >= price; j--) {
                dp[j] = Math.max(dp[j - price] + memory, dp[j]);
            }
        }
        for (int i = 0; i <= 10000; i++) {
            if (dp[i] >= m) {
                System.out.println(i);
                break;
            }
        }
    }
}
