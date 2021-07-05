package baekjoon.datastructure;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class test2493 {

    public static class Top{
        int idx;
        int h;
        public Top(int idx, int h){
            this.idx=idx;
            this.h=h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Top> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Top arr[] = new Top[n+1];
        int ans[] = new int[n+1];
        for(int i=1; i<=n; i++){
           arr[i]=new Top(i,Integer.parseInt(st.nextToken()));
        }
        for(int i=n; i>=1; i--){
            int left = arr[i].h;
            while(!s.isEmpty() && left >= s.peek().h){
                    ans[s.peek().idx]=i;
                    s.pop();
            }
            s.add(new Top(i,left));
        }
        for(int i=1; i<=n; i++){
            bw.write(ans[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
