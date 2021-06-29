package baekjoon.divideconquer;

import java.util.Scanner;

public class test5904 {
    static int arr[];
    static String ans = "";
    public static void solve(int k,int n){
        if(!ans.equals(""))
            return;
        if(k == 0){
            if( n > 1)
                ans = "o";
            else
                ans = "m";
            return;
        }
        if( arr[k-1] < n && n < arr[k-1]+k+4){ //가운데 구간일때
            if(arr[k-1]+1 == n)
                ans = "m";
            else
                ans = "o";
            return;
        }
        else{ //가운데구간이 아닐때
            if( n <= arr[k-1]){ //왼쪽구간
                solve(k-1,n);
            }else if( n > arr[k-1]+k+3 ){ //오른쪽 구간을 왼쪽구간으로 변경
                solve(k-1, n-(arr[k-1]+k+3));
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[28];
        arr[0] = 3;
        for(int i=1; i<arr.length; i++){
            arr[i] = arr[i-1]*2 + i+3;
            if(arr[i] > n){
                solve(i,n);
                break;
            }
        }
        System.out.println(ans);
    }
}
