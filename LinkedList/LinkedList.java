public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int Size = 0;

    public void traverse(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addInMiddle(int index, int data) {
        if(index == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Size++;
        Node temp = head;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        int i = 0;

        while (i < index - 1) {
            i++;
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        Size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // linking
        tail.next = newNode;

        tail = newNode;
    }

    public void addFirst(int data) {

        // step 1 = creating the linked list
        Node newNode = new Node(data);
        Size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // linking
        newNode.next = head;

        head = newNode;

    }

    public void removeFirst(){
        if(Size==0){
            return;
        }
        if(Size==1){
            System.out.println(head.data + " is the first element which is removed");
            head = tail = null;
            return;
        }
        System.out.println(head.data + " is the first element which is removed");
        head = head.next;
    }

    public void removeLast(){
        if(Size==0){
            return;
        }
        if(Size==1){
            System.out.println(head.data + " is the last element which is removed");
            head = tail = null;
            return;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        System.out.println(temp.next.data + " is the last element which is removed");
        temp.next = null;
        tail = temp;
    }

    public int helper(Node head, int val){
        if(head == null){
            return -1;
        }
        if(head.data == val){
            return 0;
        }
        int idx = helper(head.next, val);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public int recSerach(int val){
        return helper(head, val);
    }

    public void reverse(){
        Node prev = null;
        Node curent = tail =  head;
        Node next = null;
        while(curent!=null){
            next = curent.next;
            curent.next = prev;
            prev = curent;
            curent = next;
        }
        head = prev;
    }

    public void deleteNthFromend(int n){
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
            
        }
        if(n == size){
            removeLast();
            return;
        }
        int idx = size - n;
        int count = 0;
        Node temp = head;
        while(count != idx-1){
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);

        ll.addLast(0);
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.traverse(head);

        ll.reverse();
        ll.traverse(head);
      

      
    }
}
