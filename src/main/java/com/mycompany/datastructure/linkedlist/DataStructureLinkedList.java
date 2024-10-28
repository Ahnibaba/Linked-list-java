/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.datastructure.linkedlist;

/**
 *
 * @author Ani
 */
public class DataStructureLinkedList {

    static class Node {

        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static Node head = null; // Initialize head to null

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    static void push(Node head, int val) {
        Node current = head;

        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }

        // Create a new node and add it to the end
        current.next = new Node(val);
    }

    // Method to add a new node at the beginning of the linked list
    static void pushBegin(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    
    static void popFirst() {
        Node nextItem = head.next;
        head = nextItem;
        
    }
    
    static void popLast() {
        if(head == null){
         throw new IllegalStateException("List is empty");
        }
          if (head.next == null) {
            head = null;
            
        }
         // Traverse to the second-to-last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;  // Remove the last node
        
    }  
    
    static int removeByIndex(int index) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        // If removing the head node
        if (index == 0) {
            int retval = head.val;
            head = head.next;
            return retval;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                return -1; // Index out of bounds
            }
            current = current.next;
        }
        // Current node is now the node before the one we want to remove
        Node tempNode = current.next;
        if (tempNode == null) {
            return -1; // Index out of bounds
        }

        int retval = tempNode.val;
        current.next = tempNode.next; // Remove the node
        return retval;
    }
        
    
    

    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2); // Second node
        head.next.next = new Node(3);

        System.out.println("Node value: " + head.val);
        System.out.println("Next node: " + head.next);

        // Add another value to the list
        push(head, 6);

        // Add another value to the begining list
        pushBegin(89);
        
        popFirst();
        
        popLast();
        
        removeByIndex(1);

        // Print the linked list
        printList(head);
        
        
    }

}
