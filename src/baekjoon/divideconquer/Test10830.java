package baekjoon.divideconquer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test10830 {

    static int n, MOD = 1000;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        long b = parseLong(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = parseInt(st.nextToken()) % MOD;
            }
        }
        int[][] ans = solve(arr, b);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(ans[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] solve(int[][] tmp, long b) {
        if(b == 1) {
            return tmp;
        }
        int[][] result = solve(tmp, b / 2);
        result = multiply(result, result);
        if(b % 2 == 1) {
            result = multiply(result, arr);
        }
        return result;
    }

    public static int[][] multiply(int[][] arr1, int[][] arr2){
        int[][] tmp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    tmp[i][j]+= arr1[i][k] *arr2[k][j];
                    tmp[i][j] %= MOD;
                }
            }
        }
        return tmp;
    }
}
