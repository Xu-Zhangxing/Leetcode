public class CycleLinkedlist2{
  public ListNode detectCycle(ListNode head) {
      if(head==null||head.next==null) return null;
      ListNode first = head.next;
      ListNode last = head;
      while(first!=null&&first.next!=null){
          first = first.next.next;
          last = last.next;
          if(first==last){
              ListNode ptr = head;//增设ptr
              last = last.next;//last节点需要先往后移动一个距离
              while(ptr!=last){
                  ptr=ptr.next;
                  last=last.next;
              }
              return ptr;
          }
      }
      return null;
  }
}
