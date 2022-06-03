package baekjoon.tree;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class test5639 {

    static Node head;

    static class Node {

        int num;
        Node left;
        Node right;

        Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = parseInt(br.readLine());
        head = new Node(num);
        while (true) {
            String s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            num = parseInt(s);
            Node now = head;
            Node node = new Node(num);
            while (true) {
                if (now.num > node.num) {
                    if (now.left == null) {
                        now.left = node;
                        break;
                    }
                    now = now.left;
                } else {
                    if (now.right == null) {
                        now.right = node;
                        break;
                    }
                    now = now.right;
                }
            }
        }
        postOrder(head);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
