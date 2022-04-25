package baekjoon.implementation;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test16967 {

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = parseInt(st.nextToken());
        int w = parseInt(st.nextToken());
        int x = parseInt(st.nextToken());
        int y = parseInt(st.nextToken());
        int[][] arr = new int[h + 1][w + 1];
        int[][] brr = new int[h + x + 1][w + y + 1];
        for (int i = 1; i <= h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= w + y; j++) {
                brr[i][j] = parseInt(st.nextToken());
            }
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                if ((i <= x) || (j <= y )) {
                    arr[i][j] = brr[i][j];
                } else {
                    arr[i][j] = brr[i][j] - arr[i - x][j - y];
                }
            }
        }
        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
