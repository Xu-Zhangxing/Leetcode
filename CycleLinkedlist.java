/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class CycleLinkedlist{
  public boolean hasCycle(ListNode head) {
      if(head==null||head.next==null){
          return false;
      }
      ListNode first = head.next;
      ListNode last = head;
      while(first!=last){
          if(first==null||first.next==null){
              return false;
          }
          first = first.next.next;
          last = last.next;
      }
      return true;
  }
}
