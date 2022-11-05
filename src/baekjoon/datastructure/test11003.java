package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class test11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int l = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>(); //add -> addLast
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = parseInt(st.nextToken());
            arr[i] = num;
            while (!deque.isEmpty() && arr[deque.peekLast()] > num) {
                deque.pollLast();
            }
            deque.addLast(i);
            sb.append(arr[deque.peekFirst()]).append(" ");
            if (!deque.isEmpty() && deque.peekFirst() <= i - l + 1) {
                deque.pollFirst();
            }
        }
        System.out.println(sb);
    }
}
