package baekjoon.greedy;

import java.util.Scanner;

public class test13305 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long len[] = new long[n - 1];
        long oil[] = new long[n];
        for (int i = 0; i < n - 1; i++) {
            len[i] = sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            oil[i] = sc.nextLong();
        }
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            long sum = 0;
            long cnt = 0;
            for (int j = i + 1; j < n; j++) {
                sum += len[j - 1];
                if (oil[i] > oil[j]) {
                    break;
                }
                cnt++;
            }
            ans += (sum * oil[i]);
            i += cnt;
        }
        System.out.println(ans);
    }
}
