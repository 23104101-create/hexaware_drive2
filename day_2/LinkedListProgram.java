class Node {
    int data;
    Node next;

    Node(int info) {
        data = info;
        next = null;
    }
}

class LinkedList {
    Node head = null;

    // Add at beginning
    void addAtBeginning(int data) {
        Node ptr = new Node(data);
        ptr.next = head;
        head = ptr;
    }

    // Add at end
    void addAtLast(int data) {
        Node ptr = new Node(data);

        if (head == null) {
            head = ptr;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = ptr;
        }
    }

    // Add at specific position (positions start at 1)
    void addAtPosition(int data, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        Node ptr = new Node(data);
        if (pos == 1) {
            ptr.next = head;
            head = ptr;
            return;
        }

        Node temp = head;
        int l = 1;
        while (temp != null && l < pos - 1) {
            temp = temp.next;
            l++;
        }

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }

        ptr.next = temp.next;
        temp.next = ptr;
    }

    // Delete at beginning
    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete at end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        Node save = null;
        while (temp.next != null) {
            save = temp;
            temp = temp.next;
        }
        save.next = null;
    }

    // Delete at specific position (positions start at 1)
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }

        if (pos == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        int l = 1;
        while (temp != null && l < pos - 1) {
            temp = temp.next;
            l++;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Invalid position");
            return;
        }

        temp.next = temp.next.next;
    }

    // Display linked list
    void show() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class LinkedListProgram {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addAtLast(10);
        list.addAtLast(20);
        list.addAtLast(30);
        list.addAtLast(40);

        System.out.println("Original Linked List:");
        list.show();

        list.addAtBeginning(5);
        System.out.println("\nAfter adding at beginning:");
        list.show();

        list.addAtLast(50);
        System.out.println("\nAfter adding at end:");
        list.show();

        list.addAtPosition(25, 4);
        System.out.println("\nAfter adding 25 at position 4:");
        list.show();

        list.deleteAtBeginning();
        System.out.println("\nAfter deleting at beginning:");
        list.show();

        list.deleteAtEnd();
        System.out.println("\nAfter deleting at end:");
        list.show();

        list.deleteAtPosition(3);
        System.out.println("\nAfter deleting at position 3:");
        list.show();
    }
}