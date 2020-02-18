import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;

        while (node != null) {
            if (node.value == _value) {
                if (node == this.head) {
                    if (node.next == null) {
                        this.head = null;
                        this.tail = null;
                    } else {
                        this.head = node.next;
                        this.head.prev = null;
                    }
                } else {
                    if (node.next == null) {
                        this.tail = node.prev;
                        this.tail.next = null;
                    } else {
                        node.prev.next = node.next;
                        node.next.prev = node.prev;
                    }
                }
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        while (remove(_value)) {

        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        Node node = this.head;
        int length = 0;

        while (node != null) {
            length = length + 1;
            node = node.next;
        }
        return length;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        Node node = this.head;

        if (node == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
        }

        while (node != null) {
            if (node == _nodeAfter) {
                _nodeToInsert.next = node.next;
                if (node.next == null) {
                    this.tail = _nodeToInsert;
                } else {
                    node.next.prev = _nodeToInsert;
                }
                node.next = _nodeToInsert;
                _nodeToInsert.prev = node;
            }
            if (_nodeAfter == null) {
                _nodeToInsert.next = node;
                node.prev = _nodeToInsert;
                this.head = _nodeToInsert;
                break;
            }
            node = node.next;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}