package baekjoon.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int result = 0;
        int tmp = 1;
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
                tmp *= 2;
            } else if (c == '[') {
                st.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (st.isEmpty() || st.peek() != '(') {
                    result = 0;
                    break;
                }
                if (s.charAt(i - 1) == '(') {
                    result += tmp;
                }
                st.pop();
                tmp /= 2;
            } else {
                if (st.isEmpty() || st.peek() != '[') {
                    result = 0;
                    break;
                }
                if (s.charAt(i - 1) == '[') {
                    result += tmp;
                }
                st.pop();
                tmp /= 3;
            }
        }
        System.out.println(st.isEmpty() ? result : 0);
    }
}
