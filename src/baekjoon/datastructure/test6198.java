package baekjoon.datastructure;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class test6198 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();
        long ans = 0;
        for(int i=0; i<n; i++){
            int h = parseInt(br.readLine());
            while(!st.isEmpty() && st.peek() <= h){
                st.pop();
            }
            ans += st.size();
            st.push(h);
        }
        System.out.println(ans);
    }
}
