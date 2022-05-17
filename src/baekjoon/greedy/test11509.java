package baekjoon.greedy;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class test11509 { //https://www.acmicpc.net/source/39359552

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            int num = parseInt(st.nextToken());
            if (arr[num] == 0) {
                cnt++;
            } else {
                arr[num]--;
            }
            arr[num - 1]++;
        }
        System.out.println(cnt);
    }
}
