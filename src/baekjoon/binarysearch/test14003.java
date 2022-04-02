package baekjoon.binarysearch;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class test14003 {

    static int MIN = -1000000001;
    static int[] dp;
    static int[] arr;
    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[n + 1];
        arr = new int[n + 1];
        Arrays.fill(dp, MIN);
        int idx = 0;
        index = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; i++) {
            int num = arr[i];
            if (num > dp[idx]) {
                dp[++idx] = num;
                index[i] = idx;
                continue;
            }
            int k = lowerBound(idx, num);
            dp[k] = num;
            index[i] = k;
        }
        Stack<Integer> stack = new Stack<>();
        int cnt = idx;
        for (int i = n; i >= 1; i--) {
            if (index[i] == cnt) {
                stack.push(arr[i]);
                cnt--;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(idx + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }

    public static int lowerBound(int right, int target) { //target 이상의 숫자가 나타나는 최소 인덱스 리턴
        int left = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dp[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
