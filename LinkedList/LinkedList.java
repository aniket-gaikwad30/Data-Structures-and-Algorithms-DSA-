public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node head;
    public Node tail;
    public int Size = 0;

    public void traverse(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addInMiddle(int index, int data) {
        if (index == 0) {
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

        tail.next = newNode;

        tail = newNode;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        Size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;

        head = newNode;
    }

    public void removeFirst() {
        if (Size == 0) {
            return;
        }
        if (Size == 1) {
            System.out.println(head.data + " is the first element which is removed");
            head = tail = null;
            Size = 0;
            return;
        }
        System.out.println(head.data + " is the first element which is removed");
        head = head.next;
        Size--;
    }

    public void removeLast() {
        if (Size == 0) {
            return;
        }
        if (Size == 1) {
            System.out.println(head.data + " is the last element which is removed");
            head = tail = null;
            Size = 0;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        System.out.println(temp.next.data + " is the last element which is removed");
        temp.next = null;
        tail = temp;
        Size--;
    }

    public int helper(Node head, int val) {
        if (head == null) {
            return -1;
        }
        if (head.data == val) {
            return 0;
        }
        int idx = helper(head.next, val);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int recSerach(int val) {
        return helper(head, val);
    }

    public void reverse() {
        Node prev = null;
        Node curent = head;
        Node next = null;
        while (curent != null) {
            next = curent.next;
            curent.next = prev;
            prev = curent;
            curent = next;
        }
        head = prev;
    }

    public void deleteNthFromend(int n) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (n == size) {
            head = head.next;
            Size--;
            return;
        }
        int idx = size - n;
        int count = 0;
        temp = head;
        while (count < idx - 1) {
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        Size--;
    }

    public boolean isLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public Node middle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = middle();
        Node prev = null;
        Node curr = mid;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        boolean cycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle)
            return;

        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public LinkedList.Node merge(Node left, Node right) {
        if (left == null) {
            head = right;
            return right;
        }
        if (right == null) {
            head = left;
            return right;
        }
        Node result = null;
        if (left.data <= right.data) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }
        return result;
    }

    public Node mergeSortedLists(Node l1, Node l2) {
        Node dummy = new Node(-1); // dummy starting point
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach the remaining elements
        if (l1 != null)
            current.next = l1;
        if (l2 != null)
            current.next = l2;

        return dummy.next;
    }
    public void zigZag(){
        //step 1 find mid;

        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;
        //step 2 reverse the second half
        Node prev = null;
        Node curr = mid.next;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid.next = prev;
        //step 3 merge
        Node left = head;
        Node right = mid.next;
        mid.next = null;
        while(left != null && right != null){
            Node leftNext = left.next;
            Node rightNext = right.next;
            left.next = right;
            right.next = leftNext;
            left = leftNext;
            right = rightNext;
        }
    }
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        Node n1 = ll.new Node(1);
        Node n2 = ll.new Node(2);
        Node n3 = ll.new Node(3);
        Node n4 = ll.new Node(4);
        Node n5 = ll.new Node(5);

        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;

        ll.removeCycle();
        ll.traverse(ll.head);
    }
}
