package singlylinkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class provides tests for the {@link singlylinkedlist.SinglyLinkedList} class.
 *
 * @author Damien O'Reilly
 */
public class SinglyLinkedListTest {

    // ADDING TESTS

    /**
     * Test adding to the end of a singly linked list.
     */
    @Test
    public void addToLastTest() {
        String s1 = "String1";
        String s2 = "String2";
        String s3 = "String3";
        String s4 = "String4";
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);
        singlyLinkedList.addToEnd(s3);
        singlyLinkedList.addToEnd(s4);

        assertEquals(4, singlyLinkedList.getSize());

        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s2, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(s3, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(s4, singlyLinkedList.getNodeAtPosition(3).getData());
    }

    /**
     * Test adding to start of a singly linked list.
     */
    @Test
    public void addToStartTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToStart(i1);
        singlyLinkedList.addToStart(i2);
        singlyLinkedList.addToStart(i3);
        singlyLinkedList.addToStart(i4);

        assertEquals(4, singlyLinkedList.getSize());

        assertEquals(i4, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(i3, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(i2, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(i1, singlyLinkedList.getNodeAtPosition(3).getData());
    }

    /**
     * Test adding to a specified position in singly linked list.
     */
    @Test
    public void insertAtPositionTest() {

        String s1 = "String1";
        String s2 = "String2";
        String s3 = "String3";
        String s4 = "String4";
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);
        singlyLinkedList.addToEnd(s3);
        singlyLinkedList.addToEnd(s4);
        assertEquals(4, singlyLinkedList.getSize());

        String s5 = "String5";

        singlyLinkedList.insert(2, s5);
        assertEquals(5, singlyLinkedList.getSize());
        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s2, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(s5, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(s3, singlyLinkedList.getNodeAtPosition(3).getData());
        assertEquals(s4, singlyLinkedList.getNodeAtPosition(4).getData());
    }

    /**
     * Test adding to an invalid position of a singly linked list.
     */
    @Test(expected = IllegalArgumentException.class)
    public void insertAtInvalidPositionTest() {

        String s1 = "String1";
        String s2 = "String2";
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);

        String s5 = "String5";

        singlyLinkedList.insert(4, s5);
    }


    // POSITION TESTS

    /**
     * Test reading invalid position.
     */
    @Test(expected = IllegalArgumentException.class)
    public void getInvalidPositionTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addToStart(1);
        singlyLinkedList.addToStart(2);
        singlyLinkedList.getNodeAtPosition(-2);
    }

    /**
     * Test reading non existing position.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getNonExistingPosition1Test() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addToStart(1);
        singlyLinkedList.addToStart(2);
        singlyLinkedList.getNodeAtPosition(2);
    }

    /**
     * Test reading non existing position.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getNonExistingPosition2Test() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addToStart(1);
        singlyLinkedList.addToStart(2);
        singlyLinkedList.getNodeAtPosition(10);
    }

    /**
     * Test reading node at first position in empty singly linked-list.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getPositionEmptyListTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.getNodeAtPosition(0);
    }

    /**
     * Test reading node at a given position.
     */
    @Test
    public void getPositionTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);

        assertEquals(i3, singlyLinkedList.getNodeAtPosition(2).getData());
    }

    /**
     * Test reading last node.
     */
    @Test
    public void getLastPositionTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);

        assertEquals(i4, singlyLinkedList.getLastNode().getData());
    }

    /**
     * Test reading first node.
     */
    @Test
    public void getFirstPositionTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);

        assertEquals(i1, singlyLinkedList.getFirstNode().getData());
    }


    // TEST DELETING

    /**
     * Test deleting first node.
     */
    @Test
    public void deleteStartTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);

        assertEquals(4, singlyLinkedList.getSize());
        assertEquals(i1, singlyLinkedList.getFirstNode().getData());

        singlyLinkedList.deleteStart();

        assertEquals(3, singlyLinkedList.getSize());
        assertEquals(i2, singlyLinkedList.getFirstNode().getData());
    }

    /**
     * Test deleting end node.
     */
    @Test
    public void deleteEndTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);

        assertEquals(4, singlyLinkedList.getSize());
        assertEquals(i4, singlyLinkedList.getLastNode().getData());

        singlyLinkedList.deleteEnd();

        assertEquals(3, singlyLinkedList.getSize());
        assertEquals(i3, singlyLinkedList.getLastNode().getData());
    }

    /**
     * Test deleting first node from empty list.
     */
    @Test(expected = IllegalStateException.class)
    public void deleteStartEmptyListTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.deleteStart();
    }

    /**
     * Test deleting first node from single element list.
     */
    @Test
    public void deleteStartOneNodeTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addToEnd(99);
        singlyLinkedList.deleteStart();
        assertEquals(0, singlyLinkedList.getSize());
    }

    /**
     * Test deleting node from a given position.
     */
    @Test
    public void deleteAtPosition1Test() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int i1 = 453;
        int i2 = 125;
        int i3 = 976;
        int i4 = 763;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);

        assertEquals(4, singlyLinkedList.getSize());
        assertEquals(i4, singlyLinkedList.getLastNode().getData());

        singlyLinkedList.delete(2);

        assertEquals(i1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(i2, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(i4, singlyLinkedList.getNodeAtPosition(2).getData());
    }

    /**
     * Test deleting node from a given position.
     */
    @Test
    public void deleteAtPosition2Test() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        String s1 = "String1";
        String s2 = "String2";
        String s3 = "String3";
        String s4 = "String4";
        String s5 = "String5";
        String s6 = "String6";
        String s7 = "String7";

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);
        singlyLinkedList.addToEnd(s3);
        singlyLinkedList.addToEnd(s4);
        singlyLinkedList.addToEnd(s5);
        singlyLinkedList.addToEnd(s6);
        singlyLinkedList.addToEnd(s7);

        assertEquals(7, singlyLinkedList.getSize());

        singlyLinkedList.delete(4);

        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s2, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(s3, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(s4, singlyLinkedList.getNodeAtPosition(3).getData());
        assertEquals(s6, singlyLinkedList.getNodeAtPosition(4).getData());
        assertEquals(s7, singlyLinkedList.getNodeAtPosition(5).getData());
    }

    /**
     * Test deleting node from non existing position.
     */
    @Test(expected = IllegalArgumentException.class)
    public void deleteInvalidPositionTest() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.delete(9);
    }


    // REVERE TEST

    /**
     * Test reversing the linked-list iteratively.
     */
    @Test
    public void iterativeReverseTest() {

        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        String s1 = "String1";
        String s2 = "String2";
        String s3 = "String3";
        String s4 = "String4";
        String s5 = "String5";
        String s6 = "String6";
        String s7 = "String7";

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);
        singlyLinkedList.addToEnd(s3);
        singlyLinkedList.addToEnd(s4);
        singlyLinkedList.addToEnd(s5);
        singlyLinkedList.addToEnd(s6);
        singlyLinkedList.addToEnd(s7);

        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s2, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(s3, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(s4, singlyLinkedList.getNodeAtPosition(3).getData());
        assertEquals(s5, singlyLinkedList.getNodeAtPosition(4).getData());
        assertEquals(s6, singlyLinkedList.getNodeAtPosition(5).getData());
        assertEquals(s7, singlyLinkedList.getNodeAtPosition(6).getData());

        singlyLinkedList.iterativeReverse();

        assertEquals(s7, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s6, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(s5, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(s4, singlyLinkedList.getNodeAtPosition(3).getData());
        assertEquals(s3, singlyLinkedList.getNodeAtPosition(4).getData());
        assertEquals(s2, singlyLinkedList.getNodeAtPosition(5).getData());
        assertEquals(s1, singlyLinkedList.getNodeAtPosition(6).getData());

    }

    /**
     * Test reversing a single element linked-list iteratively.
     */
    @Test
    public void iterativeReverseSingleElementListTest() {

        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        String s1 = "String1";

        singlyLinkedList.addToEnd(s1);
        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());

        singlyLinkedList.iterativeReverse();
        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());
    }

    /**
     * Test reversing the linked-list with two elements iteratively.
     */
    @Test
    public void iterativeReverseTwoElementsTest() {

        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        String s1 = "String1";
        String s2 = "String2";

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);

        assertEquals(s1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s2, singlyLinkedList.getNodeAtPosition(1).getData());

        singlyLinkedList.iterativeReverse();

        assertEquals(s2, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(s1, singlyLinkedList.getNodeAtPosition(1).getData());
    }

    /**
     * Test reversing the linked-list recursively.
     */
    @Test
    public void recursiveReverseTest() {

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int i1 = 7641;
        int i2 = 32382;
        int i3 = 5363;
        int i4 = 340574;
        int i5 = 973455;
        int i6 = 354656;
        int i7 = 78767;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);
        singlyLinkedList.addToEnd(i3);
        singlyLinkedList.addToEnd(i4);
        singlyLinkedList.addToEnd(i5);
        singlyLinkedList.addToEnd(i6);
        singlyLinkedList.addToEnd(i7);

        assertEquals(i1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(i2, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(i3, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(i4, singlyLinkedList.getNodeAtPosition(3).getData());
        assertEquals(i5, singlyLinkedList.getNodeAtPosition(4).getData());
        assertEquals(i6, singlyLinkedList.getNodeAtPosition(5).getData());
        assertEquals(i7, singlyLinkedList.getNodeAtPosition(6).getData());

        singlyLinkedList.recursiveReverse();

        assertEquals(i7, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(i6, singlyLinkedList.getNodeAtPosition(1).getData());
        assertEquals(i5, singlyLinkedList.getNodeAtPosition(2).getData());
        assertEquals(i4, singlyLinkedList.getNodeAtPosition(3).getData());
        assertEquals(i3, singlyLinkedList.getNodeAtPosition(4).getData());
        assertEquals(i2, singlyLinkedList.getNodeAtPosition(5).getData());
        assertEquals(i1, singlyLinkedList.getNodeAtPosition(6).getData());
    }

    /**
     * Test reversing a single element linked-list recursively.
     */
    @Test
    public void recursiveReverseSingleElementTest() {

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int i1 = 7641;

        singlyLinkedList.addToEnd(i1);
        assertEquals(i1, singlyLinkedList.getNodeAtPosition(0).getData());

        singlyLinkedList.recursiveReverse();
        assertEquals(i1, singlyLinkedList.getNodeAtPosition(0).getData());
    }

    /**
     * Test reversing the linked-list with two elements recursively.
     */
    @Test
    public void recursiveReverseTwoElementsTest() {

        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

        int i1 = 7641;
        int i2 = 32382;

        singlyLinkedList.addToEnd(i1);
        singlyLinkedList.addToEnd(i2);

        assertEquals(i1, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(i2, singlyLinkedList.getNodeAtPosition(1).getData());

        singlyLinkedList.recursiveReverse();

        assertEquals(i2, singlyLinkedList.getNodeAtPosition(0).getData());
        assertEquals(i1, singlyLinkedList.getNodeAtPosition(1).getData());
    }


    // TEST CLEAR

    /**
     * Test clearing the linked-list.
     */
    @Test(expected = IllegalStateException.class)
    public void clearTest() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        String s1 = "String1";
        String s2 = "String2";

        singlyLinkedList.addToEnd(s1);
        singlyLinkedList.addToEnd(s2);

        singlyLinkedList.clear();

        singlyLinkedList.getFirstNode();
    }
}