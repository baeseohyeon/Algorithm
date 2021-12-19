package baekjoon.twopointer;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test11728 { //https://www.acmicpc.net/source/27444540 참고

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int[] arr = new int[n + m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = n; i < n + m; i++) {
            arr[i] = parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for(int i=0; i<n+m; i++){
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
        br.close();

    }

}
