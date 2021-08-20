package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class test1976 {

    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        int arr[][] = new int[n + 1][n + 1];
        for(int i=1; i<=n; i++){
            parent[i]= i;
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0)
                    continue;
                merge(i,j);
            }
        }
        boolean flag = true;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        for (int i = 1; i < m; i++) {
            int next = Integer.parseInt(st.nextToken());
            now = find(now);
            next = find(next);
            if(now != next){
                flag = false;
                break;
            }
            now = next;
        }
        if (flag) {
            System.out.println("YES");
        } else
            System.out.println("NO");
    }

    private static void merge(int i, int j) {
        i = find(i);
        j = find(j);
        if(i < j){
            parent[j] = i;
        }
    }

    private static int find(int num){
        if(num == parent[num])
            return num;
        return find(parent[num]);
    }

}
