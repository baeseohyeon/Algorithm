package baekjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class test1041 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = Long.MAX_VALUE;
        int n = sc.nextInt();
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = sc.nextInt();
        }
        int[][] arr = {
            {dice[0], dice[1], dice[2]},
            {dice[0], dice[1], dice[3]},
            {dice[0], dice[2], dice[4]},
            {dice[0], dice[3], dice[4]},
            {dice[1], dice[2], dice[5]},
            {dice[1], dice[3], dice[5]},
            {dice[2], dice[4], dice[5]},
            {dice[3], dice[4], dice[5]}};
        for (int i = 0; i < 8; i++) {
            Arrays.sort(arr[i]);
        }
        if (n == 1) {
            Arrays.sort(dice);
            System.out.println(dice[0] + dice[1] + dice[2] + dice[3] + dice[4]);
            return;
        }
        for (int i = 0; i < 8; i++) {
            long a = arr[i][0];
            long b = arr[i][1];
            long c = arr[i][2];
            long up = a * (n - 2) * (n - 2) + b * (n - 2) * 4 + c * 4;
            long side1 = a * n * n * 2;
            long side2 = (a * (n - 2) * n + b * 2 * n) * 2;
            ans = Math.min(ans, up + side1 + side2);
        }
        System.out.println(ans);
    }
}
