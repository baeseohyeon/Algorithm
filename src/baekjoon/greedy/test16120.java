package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test16120 { //https://velog.io/@pss407/%EB%B0%B1%EC%A4%8016120-PPAP

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'P') {
                st.push(c);
            } else {
                if (st.size() >= 2 && i + 1 < s.length() && s.charAt(i + 1) == 'P') {
                    st.pop();
                    st.pop();
                } else {
                    System.out.println("NP");
                    return;
                }
            }
        }
        if (st.size() == 1) {
            System.out.println("PPAP");
        } else {
            System.out.println("NP");
        }
    }
}
