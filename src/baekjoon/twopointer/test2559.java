package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test2559 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        int ans =sum;
        for(int i=k; i<n; i++){
            sum += arr[i];
            sum -= arr[i-k];
            ans = Math.max(ans,sum);
        }
        System.out.println(ans);
    }
}
