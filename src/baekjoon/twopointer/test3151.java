package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test3151 { //https://sorjfkrh5078.tistory.com/78

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int target = (arr[i] + arr[j]) * -1;
                int minIdx = lowerBound(j + 1, n - 1, target);
                int maxIdx = upperBound(j + 1, n - 1, target);
                ans += maxIdx - minIdx;
            }
        }
        System.out.println(ans);
    }

    private static int lowerBound(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static int upperBound(int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
