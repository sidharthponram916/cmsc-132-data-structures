package LinkedLists;

public class MyLinkedList {
    private ListNode head;
    private int size;

    private class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

    public MyLinkedList() {

    }

    public MyLinkedList(int val) {
        head = new ListNode(val);
    }

    void add(int newVal) {
        if (head == null) {
            head = new ListNode(newVal);
        } else {
            ListNode temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new ListNode(newVal);
        }

        size++;
    }

    public boolean contains(int target) {
        ListNode temp = head;

        while (temp != null) {
            if (temp.val == target) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    public int get(int index) {
        ListNode temp = head;

        int i = 0;
        while (temp != null) {
            if (i == index) {
                return temp.val;
            }

            temp = temp.next;
            i++;
        }

        return -1;
    }

    public int indexOf(int target) {
        ListNode temp = head;

        int index = 0;
        while (temp != null) {
            if (target == temp.val) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    void set(int newVal, int index) {
        ListNode temp = head;

        if (index >= size || index < 0) throw new IndexOutOfBoundsException();

        int i = 0;
        while (temp != null) {
            if (i == index) {
                temp.val = newVal;
                break;
            }

            temp = temp.next;
            i++;
        }
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0 ? true : false;
    }

    // Using Tom and Jerry Traversal 

    int remove(int index) {
        ListNode prev = null;
        ListNode temp = head;

        int i = 0;
        while (temp != null) {
            if (i == index) {
                int val = temp.val;

                if (temp == head) {
                    head = head.next;
                } else {
                    prev.next = temp.next;
                }

                return val;
            } else {
                prev = temp;
                temp = temp.next;
                i++;
            }

        }
        return 0;
    }

    void add(int newVal, int index) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode newNode = new ListNode(newVal);

        if (index == 0) {
            newNode.next = temp;
            head = newNode;
        } else {
            int i = 0;

            // 5 -> 7 -> 9 -> 2 (index 1, add 2) 5 -> 2 -> 7 -> 9 -> 2

            while (temp != null) {
                if (i == index) {
                    newNode.next = temp;
                    prev.next = newNode;
                    return;
                }

                prev = temp;
                temp = temp.next;
                i++;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        result += "[";

        ListNode temp = head;

        while (temp.next != null) {
            result += temp.val + ", ";
            temp = temp.next;
        }

        result += temp.val + "]";

        return result;
    }
}
