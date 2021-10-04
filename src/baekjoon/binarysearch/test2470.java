package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2470 {
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int i = 0, j = n-1;
        int num = MAX;
        int[] ans = new int[2];
        while (i < j) {
            int sum = Math.abs(arr[i]+arr[j]);
            if (sum < num) {
                num = sum;
                ans[0] = arr[i];
                ans[1] = arr[j];
            }
            if(Math.abs(arr[i]) < Math.abs(arr[j])){
                j--;
            }else{
                i++;
            }
        }
        Arrays.sort(ans);
        System.out.println(ans[0]+" "+ans[1]);
    }
}
