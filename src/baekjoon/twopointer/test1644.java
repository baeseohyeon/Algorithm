package baekjoon.twopointer;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test1644 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> primeNumbers = new ArrayList<>();
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i * i <= n; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j <= n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0)
                primeNumbers.add(i);
        }
        int sum = 0, cnt = 0, i = 0, j = 0;
        while (true) {
            if (sum >= n) {
                sum -= primeNumbers.get(i++);
            } else if (j == primeNumbers.size()) {
                break;
            } else {
                sum += primeNumbers.get(j++);
            }
            if (sum == n)
                cnt++;
        }
        System.out.println(cnt);
    }
}
