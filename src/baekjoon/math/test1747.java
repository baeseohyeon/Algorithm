package baekjoon.math;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1747 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        while (true) {
            if (isPrime(n) && isPalindrome(n)) {
                System.out.println(n);
                break;
            }
            n++;
        }
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(int j) {
        String num = Integer.toString(j);
        int left = 0, right = num.length() - 1;
        while (left < right) {
            if (num.charAt(left++) != num.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
