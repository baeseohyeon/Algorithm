package baekjoon.bruteforce;

import java.io.IOException;
import java.util.Scanner;

public class Test1107 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        boolean[] isBrokenButtons = new boolean[10];
        int target = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            isBrokenButtons[sc.nextInt()] = true;
        }
        int ans = Math.abs(target - 100);
        for (int i = 0; i <= 999999; i++) {
            String channel = Integer.toString(i);
            boolean hasBrokenButton = false;
            for (int j = 0; j < channel.length(); j++) {
                int num = channel.charAt(j) - '0';
                if (isBrokenButtons[num]) {
                    hasBrokenButton = true;
                    break;
                }
            }
            if (hasBrokenButton) {
                continue;
            }
            ans = Math.min(ans, channel.length() + Math.abs(target - i));
        }
        System.out.println(ans);
    }
}