var middleNode = function(head) {
    let slow = head;
    let fast = head;
    
    while (fast !== null && fast.next !== null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  
  function createLinkedList(arr) {
    let dummy = new ListNode(0);
    let curr = dummy;
    
    for ( let val of arr) {
      curr.next = new ListNode(val);
      curr = curr.next;
    }
    return dummy.next;
  }