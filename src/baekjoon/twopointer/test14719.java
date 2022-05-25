package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test14719 { //https://jminie.tistory.com/106

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = parseInt(st.nextToken());
        int w = parseInt(st.nextToken());
        int[] arr = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int left = 0, right = w - 1;
        int cnt = 0;
        int leftMax = arr[left], rightMax = arr[w - 1];
        while (left < right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (leftMax < rightMax) {
                cnt += leftMax - arr[left];
                left++;
            } else {
                cnt += rightMax - arr[right];
                right--;
            }
        }
        System.out.println(cnt);
    }
}
