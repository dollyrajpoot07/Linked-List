import java.util.*;

public class LinkedList {
    static Node head;
    private int size;

    LinkedList() {
        size = 0;
    }

    public class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    
    public Node swapPairs(Node head) {
        if(head==null ||head.next ==null)
            return head;
        Node l1=head,l2=head.next;
        Node l3=l2.next;
        l2.next=l1;
        l1.next=l2;
        l1.next=swapPairs(l3);
        return l2;
    }

    public Node reverseListRecursive(Node head) {
        // empty node || last node or only one node
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;
    }

    public void printList() {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }

        head = LinkedList.head.next;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Empty List, nothing to delete");
            return;
        }

        size--;
        if (head.next == null) {
            head = null;
            return;
        }

        Node currNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            currNode = currNode.next;
            lastNode = lastNode.next;
        }

        currNode.next = null;
    }

    public int getSize() {
        return size;
    }

    public void addInMiddle(int index, String data) {
        if (index > size || index < 0) {
            System.out.println("Invalid Index value");
            return;
        }
        size++;

        Node newNode = new Node(data);
        if (head == null || index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currNode = head;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                Node nextNode = currNode.next;
                currNode.next = newNode;
                newNode.next = nextNode;
                break;
            }
            currNode = currNode.next;
        }
    }

    public Node reverseBetween(Node head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // move to the beginning point, base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    Node successor = null;

    // reverse the nth point from head
    Node reverseN(Node head, int n) {
        if (n == 1) {
            // record n + 1 point
            successor = head.next;
            return head;
        }

        Node last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = successor;
        return last;
    }

    public Node removeNthFromEnd(Node head, int n) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        if (count == n)
            return head.next;
        curr = head;
        int x = 0;
        while (x < count - n - 1) {
            curr = curr.next;
            x++;
        }
        Node k = curr.next;
        if (k != null)
            curr.next = k.next;
        else
            curr.next = null;
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        // int left = sc.nextInt();
        // int right = sc.nextInt();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.printList();
        list.addFirst("4");
        list.printList();
        System.out.println(list.getSize());
        list.removeFirst();
        list.printList();
        list.removeLast();
        list.printList();
        
        list.reverseBetween(head, 2,4);
        list.printList();
        LinkedList.head = list.reverseListRecursive(LinkedList.head);
        list.printList();

        sc.close();
    }

    public void rotate(int i) {
    }

    public void push(int i) {
    }

    public void add(int nextInt) {
    }
}

