package baekjoon.math;

import java.util.Arrays;
import java.util.Scanner;

public class test1016 { //https://blog.crazzero.com/34 참고

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] isPowNoNoNumber = new boolean[(int) (max - min + 1)];
        Arrays.fill(isPowNoNoNumber, true);
        for (long i = 2; i * i <= max; i++) {
            long num = i * i;
            long divided = min % num == 0 ? min / num : min / num + 1;
            for (long j = divided; num * j < max - min + 1; j++) {
                isPowNoNoNumber[(int) (num * j)] = false;
            }
        }
        int cnt = 0;
        for (int i = 0; i < max - min + 1; i++) {
            if (isPowNoNoNumber[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
