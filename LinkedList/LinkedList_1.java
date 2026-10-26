package LinkedList;

import java.util.*;

public class LinkedList_1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        Node tail = null;
        for (int i = 0; i < n; i++) {
            Node node = new Node(sc.nextInt());
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        print(head);
    }

    static Node insertAtBeg(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    static Node insertAtEnd(Node head, int data) {
        Node node = new Node(data);
        Node temp = head;
        if (head == null)
            return node;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        return head;

    }

    static Node deleteAtBeg(Node head) {
        if (head == null)
            return null;

        head = head.next;
        return head;
    }

    static Node deleteAtPos(Node head, int pos) {
        if (head == null || pos < 1)
            return head;
        if (pos == 1)
            return deleteAtBeg(head);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return head;
        temp.next = temp.next.next;
        return head;
    }

    static Node deleteAtEnd(Node head) {

        if (head == null || head.next == null)
            return null;
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;

        }
        temp.next = null;
        return head;
    }

    static Node insertAtPos(Node head, int pos, int data) {
        if (pos < 1)
            return head;
        if (pos == 1)
            return insertAtBeg(head, data);

        Node node = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null)
            return head;
        node.next = temp.next;
        temp.next = node;
        return head;

    }

    static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.next == null)
                System.out.println(temp.data);
            else
                System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }
}