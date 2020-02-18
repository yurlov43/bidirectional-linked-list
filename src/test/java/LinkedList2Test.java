import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LinkedList2Test {

    @Test
    public void remove_FIRST_ITEM() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.remove(17);
        Assert.assertEquals(linkedList2.head.value, 35);
        Assert.assertEquals(linkedList2.tail.value, 35);
    }

    @Test
    public void remove_LAST_ITEM() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.remove(35);
        Assert.assertEquals(linkedList2.head.value, 17);
        Assert.assertEquals(linkedList2.tail.value, 17);
    }

    @Test
    public void remove_MIDDLE_ITEM() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(16));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(88));
        linkedList2.remove(35);
        Assert.assertEquals(linkedList2.head.value, 16);
        Assert.assertEquals(linkedList2.tail.value, 88);
        Assert.assertEquals(linkedList2.tail.prev, linkedList2.head);
        Assert.assertEquals(linkedList2.tail, linkedList2.head.next);
    }

    @Test
    public void remove_ONLY_ITEM_IN_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(35));
        linkedList2.remove(35);
        Assert.assertEquals(linkedList2.head, null);
        Assert.assertEquals(linkedList2.tail, null);
    }

    @Test
    public void remove_ITEM_FROM_EMPTY_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.remove(35);
        Assert.assertEquals(linkedList2.head, null);
        Assert.assertEquals(linkedList2.tail, null);
    }

    @Test
    public void removeAll() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.removeAll(17);
        Assert.assertEquals(linkedList2.head.value, 35);
        Assert.assertEquals(linkedList2.tail.value, 35);
    }

    @Test
    public void removeAll_GET_AN_EMPTY_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(17));
        linkedList2.removeAll(17);
        Assert.assertEquals(linkedList2.head, null);
        Assert.assertEquals(linkedList2.tail, null);
    }

    @Test
    public void remove_FROM_EMPTY_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        Node n1 = new Node(17);
        linkedList2.remove(n1.value);
        Assert.assertEquals(linkedList2.head, null);
        Assert.assertEquals(linkedList2.tail, null);
    }

    @Test
    public void clear() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(99));
        linkedList2.clear();
        Assert.assertEquals(linkedList2.head, null);
        Assert.assertEquals(linkedList2.tail, null);
    }

    @Test
    public void findAll() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        ArrayList<Node> matchesList = linkedList2.findAll(17);
        Assert.assertEquals(matchesList.size(), 2);
        for (int i = 0; i < matchesList.size(); i += 1) {
            Assert.assertEquals(matchesList.get(i).value, 17);
        }
    }

    @Test
    public void findAll_NOT_FIND_ALL_ITEMS() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(16));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        ArrayList<Node> matchesList = linkedList2.findAll(7);
        Assert.assertEquals(matchesList.size(), 0);
        ArrayList testList = new ArrayList();
        Assert.assertEquals(matchesList, testList);
    }

    @Test
    public void findAll_ITEMS_IN_LIST_WITH_ONE_ITEM() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        ArrayList<Node> matchesList = linkedList2.findAll(17);
        Assert.assertEquals(matchesList.size(), 1);
        for (int i = 0; i < matchesList.size(); i += 1) {
            Assert.assertEquals(matchesList.get(i).value, 17);
        }
    }

    @Test
    public void findAll_IN_EMPTY_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        ArrayList<Node> matchesList = linkedList2.findAll(17);
        Assert.assertEquals(matchesList.size(), 0);
        for (int i = 0; i < matchesList.size(); i += 1) {
            Assert.assertEquals(matchesList.get(i).value, null);
        }
    }

    @Test
    public void find() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        Assert.assertEquals(linkedList2.find(17).value, 17);
        Assert.assertEquals(linkedList2.find(17), linkedList2.head);
    }

    @Test
    public void find_NOT_FIND_ITEM() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        Assert.assertEquals(linkedList2.find(6), null);
    }

    @Test
    public void find_IN_LIST_WITH_ONE_ITEM() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        Assert.assertEquals(linkedList2.find(17).value, 17);
        Assert.assertEquals(linkedList2.find(17), linkedList2.head);
        Assert.assertEquals(linkedList2.find(17), linkedList2.tail);
    }

    @Test
    public void find_EMPTY_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        Assert.assertEquals(linkedList2.find(17), null);
    }

    @Test
    public void count() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        Assert.assertEquals(linkedList2.count(), 4);
    }

    @Test
    public void count_EMPTY_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        Assert.assertEquals(linkedList2.count(), 0);
    }

    @Test
    public void insertAfter() {
        LinkedList2 linkedList2 = new LinkedList2();
        Node n1 = new Node(17);
        linkedList2.addInTail(n1);
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        Node n2 = new Node(5);
        linkedList2.insertAfter(n1, n2);
        Assert.assertEquals(linkedList2.head.next, n2);
        Assert.assertEquals(linkedList2.head, n2.prev);
        Assert.assertEquals(35, n2.next.value);
    }

    @Test
    public void insertAfter_LIST_IS_NONE() {
        LinkedList2 linkedList2 = new LinkedList2();
        Node n1 = new Node(17);
        linkedList2.insertAfter(null, n1);
        Assert.assertEquals(linkedList2.head.value, 17);
        Assert.assertEquals(linkedList2.head, n1);
        Assert.assertEquals(linkedList2.tail, n1);
        Assert.assertEquals(null, n1.next);
        Assert.assertEquals(null, n1.prev);
    }

    @Test
    public void insertAfter_AT_END_OF_LIST() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        Node n1 = new Node(7);
        linkedList2.addInTail(n1);
        Node n2 = new Node(5);
        linkedList2.insertAfter(n1, n2);
        Assert.assertEquals(linkedList2.tail, n2);
        Assert.assertEquals(7, n2.prev.value);
        Assert.assertEquals(n1.next, n2);
        Assert.assertEquals(n2.next, null);
    }

    @Test
    public void insertAfter_ADD_IN_HEAD() {
        LinkedList2 linkedList2 = new LinkedList2();
        linkedList2.addInTail(new Node(35));
        linkedList2.addInTail(new Node(17));
        linkedList2.addInTail(new Node(99));
        Node n1 = new Node(6);
        linkedList2.insertAfter(null, n1);
        Assert.assertEquals(linkedList2.head.value, 6);
        Assert.assertEquals(linkedList2.head, n1);
        Assert.assertEquals(35, n1.next.value);
        Assert.assertEquals(null, n1.prev);
    }
}