package baekjoon.dp;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test10942 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[n+1];
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i=1; i<=n; i++){
            arr[i]=parseInt(s[i-1]);
        }

        for(int i=1; i<=n; i++){
            dp[i][i]=true;
        }

        for(int i=1; i<n; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1]=true;
            }
        }

        for(int i=2; i<=n; i++){
            for(int j=1; i+j<=n; j++){
                if(dp[j+1][i+j-1] && arr[j] == arr[j+i]){
                    dp[j][i+j]=true;
                }
            }
        }

        int m = parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            s = br.readLine().split(" ");
            sb.append(dp[parseInt(s[0])][parseInt(s[1])]? "1" : "0").append("\n");
        }
        System.out.println(sb);
    }
}
