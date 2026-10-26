package LinkedList;

import java.util.*;

public class LinkedList_2 {
   static class Node {
      int data;
      Node next;
      Node prev;

      Node(int data) {
         this.data = data;
         this.next = null;
         this.prev = null;
      }
   }

   public static void main(String args[]) {

      Scanner sc = new Scanner(System.in);
      Node head = null;
      Node tail = null;

      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
         Node node = new Node(sc.nextInt());
         if (head == null) {
            head = node;
            tail = node;
         } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
         }
      }
      displayReverse(head);
   }

   public static void display(Node head) {
      Node temp = head;
      while (temp != null) {
         System.out.print(temp.data);
         if (temp.next != null)
            System.out.print("<->");

         temp = temp.next;
      }
   }

   static Node insertAtHead(Node head, int data) {

      Node node = new Node(data);

      node.next = head;

      if (head != null) {
         head.prev = node;
      }
      head = node;
      return head;
   }

   static Node insertAtPos(Node head, int pos, int data) {
      Node node = new Node(data);
      Node temp = head;
      if (pos < 1)
         return head;
      if (pos == 1) {
         return insertAtHead(head, data);
      }
      for (int i = 1; i < pos - 1 && temp != null; i++) {
         temp = temp.next;
      }
      if (temp == null) {
         return null;
      }
      node.next = temp.next;
      node.prev = temp;
      if (temp.next != null)
         temp.next.prev = node;
      temp.next = node;
      return head;

   }

   public static Node lastElement(Node head) {
      Node temp = head;
      if (head == null)
         return null;
      while (temp.next != null) {
         temp = temp.next;
      }
      return temp;
   }

   public static void displayReverse(Node head) {
      Node tail = lastElement(head);
      while (tail != null) {
         System.out.print(tail.data);
         if (tail.prev != null)
            System.out.print("<->");

         tail = tail.prev;
      }

   }
}
