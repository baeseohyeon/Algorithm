package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test1406 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            left.push(s.charAt(i));
        }
        int m = parseInt(br.readLine());
        while (m-- > 0) {
            String order = br.readLine();
            if (order.equals("L")) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }
            if (order.equals("D")) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
            if (order.equals("B")) {
                if (!left.isEmpty()) {
                    left.pop();
                }
            }
            if (order.charAt(0) == 'P') {
                left.push(order.charAt(2));
            }
        }
        StringBuffer sb = new StringBuffer();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}
