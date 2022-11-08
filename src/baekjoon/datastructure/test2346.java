package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class test2346 {

    static class Balloon {

        int num, idx;

        Balloon(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Deque<Balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deque.add(new Balloon(parseInt(st.nextToken()), i + 1));
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            Balloon balloon = deque.pollFirst();
            int num = Math.abs(balloon.num);
            sb.append(balloon.idx).append(" ");
            if (deque.isEmpty()) {
                break;
            }
            if (balloon.num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < num; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        System.out.println(sb);
    }
}
