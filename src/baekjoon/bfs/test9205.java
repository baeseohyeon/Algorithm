package baekjoon.bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test9205 {

    public static class XY{
        int x,y,beer;
        public XY(int x, int y,int beer){
            this.x=x; this.y=y; this.beer=beer;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            Queue<XY> q = new LinkedList<>();
            int n = Integer.parseInt(br.readLine());
            String ans = "sad";
            StringTokenizer st;
            boolean visit[] = new boolean[n];
            XY store[]=new XY[n];  //편의점
            XY start; //시작점
            XY end; //도착점
            st = new StringTokenizer(br.readLine());
            start = new XY(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),20);
            for(int i=0; i<n; i++){
                st=new StringTokenizer(br.readLine());
                store[i]=new XY( Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            }
            st = new StringTokenizer(br.readLine());
            end = new XY(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
            q.add(start);
            while(!q.isEmpty()){
                XY now = q.poll();
                int now_beer = now.beer;
                int now_end = Math.abs(now.x-end.x) + Math.abs(now.y-end.y);
                if( now_end <= now_beer * 50 ){
                    ans = "happy";
                    break;
                }
                for(int i=0; i<n; i++){
                    int now_store = Math.abs(now.x-store[i].x) + Math.abs(now.y-store[i].y);
                    if(!visit[i] && now_store <= now_beer * 50) {
                        visit[i]=true;
                        q.add(new XY(store[i].x, store[i].y, 20));
                    }
                }
            }
            bw.write(ans+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
