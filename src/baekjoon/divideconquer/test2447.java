package baekjoon.divideconquer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class test2447 {

    static char arr[][] = new char[6561][6561];

    public static void solve(int w, int h, int num){
        if(num==3){
            for(int i=w; i<w+num; i++){
                for(int j=h; j<h+num; j++){
                    arr[i][j]='*';
                }
            }
            arr[w+1][h+1]=' ';
            return;
        }else{
           solve(w,h,num/3);
           solve(w,h+num/3,num/3);
           solve(w,h+num/3*2,num/3);
           solve(w+num/3,h,num/3);
           solve(w+num/3,h+num/3*2,num/3);
           solve(w+num/3*2,h,num/3);
           solve(w+num/3*2,h+num/3,num/3);
           solve(w+num/3*2,h+num/3*2,num/3);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                arr[i][j]=' ';
            }
        }
        solve(0,0,n);
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                bw.write(arr[i][j]);
            }
           bw.write('\n');
        }
        bw.flush();
    }
}
