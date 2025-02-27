/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    let dummy = new ListNode(-1); // Dummy node to simplyfy logic
    let current = dummy; // pointer for the new list

    while (list1 !== null && list2 !== null) {
        if (list1.val < list2.val) {
            current.next = list.1;
            list1 = list1.next;
        } else {
            current.next = list2;
            list2 = list2.next;
        }
        current = current.next; // Move forward in merge list
    }
    // Attach remaining elements (on of them will be null)
    current.next = list1 !== null ? list1 : list2;

    return dummy.next; // The merged list starts after the dummy node
    
};