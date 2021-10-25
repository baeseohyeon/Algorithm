package baekjoon.divideconquer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test11582 {

    public static void solve(int left, int right) {
        if(right-left+1 > 2){
            solve(left,(left+right)/2);
            solve((left+right)/2+1,right);
        }
        Arrays.sort(arr, left, right+1);
        if(n / (right-left+1)  == k){
            for(int i=left; i<=right; i++){
                ans[i]=arr[i];
            }
        }
    }
    static int ans[];
    static int arr[];
    static int k;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        ans = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        k=Integer.parseInt(br.readLine());
        solve(1,n);
        for(int i=1; i<=n; i++){
           bw.write(ans[i]+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
