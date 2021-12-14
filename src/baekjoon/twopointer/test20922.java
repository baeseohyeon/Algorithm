package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test20922 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int i = 0, j = 0, ans = 0;
        int[] nums = new int[100001];
        while (j < n) {
            nums[arr[j]]++;
            if (nums[arr[j]] > k) {
                while (nums[arr[j]] > k && i < j) {
                    nums[arr[i++]]--;
                }
            } else {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
        }
        System.out.println(ans);
    }

}
