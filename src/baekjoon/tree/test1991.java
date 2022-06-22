package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test1991 {

    static Node[] nodes;
    static StringBuffer sb;

    static class Node {

        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        nodes = new Node[26];
        sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node((char) ('A' + i));
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            char parent = s.charAt(0);
            char left = s.charAt(2);
            char right = s.charAt(4);
            if (left != '.') {
                nodes[parent - 'A'].left = nodes[left - 'A'];
            }
            if (right != '.') {
                nodes[parent - 'A'].right = nodes[right - 'A'];
            }
        }
        preOrder(nodes[0]);
        sb.append("\n");
        inOrder(nodes[0]);
        sb.append("\n");
        postOrder(nodes[0]);
        System.out.println(sb);
        br.close();
    }

    private static void preOrder(Node now) {
        if (now == null) {
            return;
        }
        sb.append(now.value);
        preOrder(now.left);
        preOrder(now.right);
    }

    private static void inOrder(Node now) {
        if (now == null) {
            return;
        }
        inOrder(now.left);
        sb.append(now.value);
        inOrder(now.right);
    }

    private static void postOrder(Node now) {
        if (now == null) {
            return;
        }
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.value);
    }
}
