package baekjoon.dfs;


import java.util.Scanner;

public class test1103 {
    public static void solve(int x, int y){
        if(!flag){
            return;
        }
        boolean check = false;
        visit[x][y]=true;
        int d = map[x][y]-'0';
        for(int i=0; i<4; i++){
            int nx = x+dx[i] * d;
            int ny = y+dy[i] * d;
            if(nx<0 || ny<0 || nx>=n || ny>=m)
                continue;
            if(visit[nx][ny]){
                flag = false;
                return;
            }else if(!visit[nx][ny] && map[nx][ny] != 'H' && dp[nx][ny]<=dp[x][y]){ //방문 안했을때
                check = true;
                dp[nx][ny]=dp[x][y]+1;
                solve(nx,ny);
            }
        }
        visit[x][y]=false;
        if(!check)
            ans = Math.max(ans,dp[x][y]+1);
    }
    static int n;
    static int m;
    static int ans = 0;
    static boolean flag = true;
    static boolean visit[][];
    static int dp[][];
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    static char map[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp = new int[n][m];
        map = new char[n][m];
        visit = new boolean[n][m];
        for(int i=0; i<n; i++){
            String s = sc.next();
            for(int j=0; j<m; j++){
                dp[i][j]=-1;
                map[i][j]=s.charAt(j);
            }
        }
        dp[0][0]=0;
        solve(0,0);
        if(flag){
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }
    }
}
