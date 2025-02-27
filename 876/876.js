/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var middleNode = function(head) {
  let slow = head; // this does not create new copies of the linked list. Instead, both slow and fast
  let fast = head; // are just references (pointers) to the same starting node.

  while ( fast !== null && fast.next !== null ) {
      slow = slow.next;
      fast = fast.next.next;
  }
  return slow;
}

// Time Complexity = O(n);
// Space Complexity = O(1);