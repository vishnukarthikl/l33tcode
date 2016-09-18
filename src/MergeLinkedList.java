import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class MergeLinkedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return Integer.compare(o1.val, o2.val);
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                heap.add(list);
            }
        }


        while (!heap.isEmpty()) {
            ListNode top = heap.poll();
            if (top.next != null) {
                heap.add(top.next);
            }
            if (head == null) {
                head = new ListNode(top.val);
                tail = head;
            } else {
                tail.next = top;
                tail = tail.next;
            }
        }
        return head;
    }
}