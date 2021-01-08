package Test;

import Data_Structs.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglyLinkedListTest {
    SinglyLinkedList linkedList;
    SinglyLinkedList.Node apples = new SinglyLinkedList.Node("Apples");
    SinglyLinkedList.Node bananas = new SinglyLinkedList.Node("Banana");
    SinglyLinkedList.Node peach = new SinglyLinkedList.Node("Peach");
    SinglyLinkedList.Node mango = new SinglyLinkedList.Node("Mango");
    SinglyLinkedList.Node orange = new SinglyLinkedList.Node("Orange");
    SinglyLinkedList.Node grape = new SinglyLinkedList.Node("Grape");
    SinglyLinkedList.Node watermelon = new SinglyLinkedList.Node("Watermelon");
    SinglyLinkedList.Node melon = new SinglyLinkedList.Node("Melon");
    SinglyLinkedList.Node pumpkin = new SinglyLinkedList.Node("Pumpkin");
    SinglyLinkedList.Node tomato = new SinglyLinkedList.Node("Tomato");
    SinglyLinkedList.Node acorn = new SinglyLinkedList.Node("Acorn");

    @BeforeEach
    public void setUp() {
        linkedList = new SinglyLinkedList();
    }

    @Test
    public void testEmptySinglyLinkedList() {
        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
    }

    @Test
    public void testInsertHead() {
        assertFalse(linkedList.insertHead(null));
        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals("", linkedList.toString());

        linkedList.insertHead(apples);
        linkedList.insertHead(mango);
        linkedList.insertHead(bananas);
        assertEquals(3, linkedList.getSize());
        assertEquals(bananas, linkedList.getHead());
        assertEquals(apples, linkedList.getTail());

        String list = "Banana => Mango => Apples";
        assertEquals(list, linkedList.toString());
        assertEquals(3, linkedList.getSize());
    }

    @Test
    public void testInsertTail() {
        assertFalse(linkedList.insertTail(null));
        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals("", linkedList.toString());

        linkedList.insertTail(apples);
        linkedList.insertTail(mango);
        linkedList.insertTail(bananas);

        String list = "Apples => Mango => Banana";
        assertEquals(list, linkedList.toString());
        assertEquals(3, linkedList.getSize());
    }

    @Test
    public void testRemoveHead() {
        assertEquals("", linkedList.removeHead());

        linkedList.insertTail(apples);
        linkedList.insertHead(peach);
        linkedList.insertTail(mango);
        linkedList.insertTail(bananas);

        String list = "Peach => Apples => Mango => Banana";
        assertEquals(list, linkedList.toString());
        assertEquals("Peach", linkedList.removeHead());
        assertEquals("Apples", linkedList.removeHead());

        list = "Mango => Banana";
        assertEquals(list, linkedList.toString());
        assertEquals(2, linkedList.getSize());
    }

    @Test
    public void testRemoveTail() {
        assertEquals("", linkedList.removeTail());

        linkedList.insertTail(apples);
        assertEquals("Apples", linkedList.removeTail());
        assertNull(linkedList.getTail());
        assertNull(linkedList.getHead());

        linkedList.insertTail(apples);
        linkedList.insertHead(peach);
        linkedList.insertTail(mango);
        linkedList.insertHead(grape);
        linkedList.insertTail(bananas);
        linkedList.insertHead(orange);

        String list = "Orange => Grape => Peach => Apples => Mango => Banana";
        assertEquals(list, linkedList.toString());

        assertEquals("Banana", linkedList.removeTail());
        assertEquals("Mango", linkedList.removeTail());
        assertEquals("Apples", linkedList.removeTail());
        assertEquals(3, linkedList.getSize());
    }

    @Test
    public void testRemove() {
        String list = "Orange => Grape => Peach => Apples => Mango => Banana";

        linkedList.insertTail(apples);
        linkedList.insertHead(peach);
        linkedList.insertTail(mango);
        linkedList.insertHead(grape);
        linkedList.insertTail(bananas);
        linkedList.insertHead(orange);

        assertFalse(linkedList.remove(null));
        assertFalse(linkedList.remove("Corn"));
        assertTrue(linkedList.remove("Peach"));

        list = "Orange => Grape => Apples => Mango => Banana";
        assertEquals(list, linkedList.toString());
        assertEquals(5, linkedList.getSize());

        assertTrue(linkedList.remove("Banana"));
        list = "Orange => Grape => Apples => Mango";
        assertEquals(list, linkedList.toString());

        linkedList.remove("Orange");
        assertEquals(3, linkedList.getSize());
    }

    @Test
    public void testInsertAtIndex() {
        String list = "Orange => Grape => Peach => Tomato => Apples => Mango => Banana";
        linkedList.insertIndex(tomato, 3);
        linkedList.insertTail(apples);
        linkedList.insertHead(peach);
        linkedList.insertTail(mango);
        linkedList.insertHead(grape);
        linkedList.insertTail(bananas);
        linkedList.insertHead(orange);
        assertEquals(list, linkedList.toString());

        list = "Orange => Watermelon => Grape => Peach => Tomato => Melon => Apples => Mango => Banana => Pumpkin";
        assertFalse(linkedList.insertIndex(null, 0));
        linkedList.insertIndex(watermelon, 1);
        linkedList.insertIndex(pumpkin, 1000);
        linkedList.insertIndex(melon, 5);

        assertEquals(list, linkedList.toString());
        assertEquals(10, linkedList.getSize());
    }

    @Test
    public void testRemoveAtIndex() {
        String list = "Orange => Grape => Peach => Tomato => Apples => Mango => Banana";
        linkedList.insertIndex(tomato, 3);
        linkedList.insertTail(apples);
        linkedList.insertHead(peach);
        linkedList.insertTail(mango);
        linkedList.insertHead(grape);
        linkedList.insertTail(bananas);
        linkedList.insertHead(orange);

        list = "Grape => Peach => Tomato => Apples => Mango => Banana";
        linkedList.removeIndex(0);
        assertEquals(list, linkedList.toString());

        list = "Grape => Peach => Tomato => Mango => Banana";
        linkedList.removeIndex(3);
        assertEquals(list, linkedList.toString());

        list = "Grape => Peach => Tomato => Mango";
        linkedList.removeIndex(4);
        assertEquals(list, linkedList.toString());
        assertEquals(4, linkedList.getSize());

        assertFalse(linkedList.removeIndex(100));
        assertEquals(4, linkedList.getSize());
    }

    @Test
    public void testReverseList() {
        String list = "Orange => Grape => Peach => Tomato => Apples => Mango => Banana";
        linkedList.insertIndex(tomato, 3);
        linkedList.insertTail(apples);
        linkedList.insertHead(peach);
        linkedList.insertTail(mango);
        linkedList.insertHead(grape);
        linkedList.insertTail(bananas);
        linkedList.insertHead(orange);

        list = "Banana => Mango => Apples => Tomato => Peach => Grape => Orange";
        linkedList.reverseList();
        assertEquals(list, linkedList.toString());
    }

    @Test
    public void testInOrderInsert() {
        String list = "Apples";

        linkedList.insertInOrder(apples);
        assertEquals(list, linkedList.toString());
        linkedList.insertInOrder(peach);
        list = "Apples => Peach";
        assertEquals(list, linkedList.toString());
        linkedList.insertInOrder(bananas);
        list = "Apples => Banana => Peach";
        assertEquals(list, linkedList.toString());

        linkedList.insertInOrder(acorn);
        list = "Acorn => Apples => Banana => Peach";
        assertEquals(list, linkedList.toString());

        linkedList.insertInOrder(mango);
        linkedList.insertInOrder(watermelon);
        linkedList.insertInOrder(pumpkin);
        linkedList.insertInOrder(grape);
        linkedList.insertInOrder(tomato);
        linkedList.insertInOrder(orange);

        list = "Acorn => Apples => Banana => Grape => Mango => Orange => Peach => Pumpkin => Tomato => Watermelon";
        assertEquals(list, linkedList.toString());
        assertEquals(10, linkedList.getSize());
    }

    @Test
    public void testContains() {
        linkedList.insertInOrder(mango);
        linkedList.insertInOrder(watermelon);
        linkedList.insertInOrder(pumpkin);
        linkedList.insertInOrder(grape);
        linkedList.insertInOrder(tomato);
        linkedList.insertInOrder(orange);

        assertFalse(linkedList.contains("cookies"));
        assertTrue(linkedList.contains("Watermelon"));
        assertTrue(linkedList.contains("Mango"));
    }
}