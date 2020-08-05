package april2020.week2;

/**
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 *
 * If there are two middle nodes, return the second middle node.
 */
  class ListNode {
     int val;
     ListNode next;
      ListNode() {}
    ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while(first != null && first.next != null) {
            second = second.next;
            first = first.next.next;
        }
        return second;
    }
}
