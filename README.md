# Sword-inger-offer
剑指offer（Java）

### 1、从尾到头打印链表

```java
public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    ArrayList<Integer> res = new ArrayList<>();

    ListNode cur = listNode;
    Stack<Integer> stack = new Stack<>();

    while (cur != null) {
        stack.push(cur.val);
        cur = cur.next;
    }

    while (!stack.isEmpty()) {
        res.add(stack.pop());
    }

    return res;
}
```

### 2、反转链表

```java
public ListNode ReverseList(ListNode head) {
    if (null == head) {
        return null;
    }
    ListNode pre = null;
    ListNode cur = head;

    while (null != cur) {
        ListNode next = cur.next;;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}
```

### 3、合并两个排序的链表

```java
public ListNode Merge(ListNode list1,ListNode list2) {

    ListNode head = new ListNode(-1);
    ListNode cur  = head;

    while (null != list1 && null != list2) {
        if (list1.val <= list2.val) {
            cur.next = list1;
            list1 = list1.next;
        } else {
            cur.next = list2;
            list2 = list2.next;
        }
        cur = cur.next;
    }

    cur.next = null==list1?list2:list1;

    return head.next;
}
```

### 4、两个链表的第一个公共结点

```java
public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

    ListNode p1 = pHead1;
    ListNode p2 = pHead2;

    while (p1 != p2) {
        p1 = null==p1?pHead2:p1.next;
        p2 = null==p2?pHead1:p2.next;
    }
    return p1;
}
```

### 5、链表中环的入口结点

```java
public ListNode EntryNodeOfLoop(ListNode pHead) {
    if (null == pHead || null == pHead.next) {
        return null;
    }

    ListNode f = pHead.next;
    ListNode s = pHead;

    while (null != f) {
        s = s.next;
        f = f.next;
        if (null == f) {
            return null;
        }
        f = f.next;
        if (f == s) {
            f = f.next;
            s = pHead;
            while (s != f) {
                f = f.next;
                s = s.next;
            }
            return s;
        }
    }
    return null;
}
```

### 6、链表中倒数最后k个结点

```java
// 双指针
 public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode f = pHead;
        ListNode s = pHead;
        while (k-- != 0) {
            if (null == f) {
                return null;
            }
            f = f.next;
        }

        while (null != f) {
            f = f.next;
            s = s.next;
        }

        return s;
    }
```

### 7、复杂链表的复制

```java
public RandomListNode Clone(RandomListNode pHead) {
    Map<RandomListNode,RandomListNode> map = new HashMap<>();
    RandomListNode cur = pHead;
    while (null != cur) {
        map.put(cur,new RandomListNode(cur.label));
        cur = cur.next;
    }

    cur = pHead;
    while (null != cur) {
         // 指向new出来的cur的下一个new
        map.get(cur).next = map.get(cur.next);
        map.get(cur).random = map.get(cur.random);
        cur = cur.next;
    }

    return map.get(pHead);
}
```

### 8、**删除链表中重复的结点**

```java
public ListNode deleteDuplication(ListNode pHead) {

    if (null == pHead) {
        return null;
    }

    ListNode dum = new ListNode(-1);
    dum.next = pHead;
    ListNode cur = dum;

    // cur.next是判断是否走到尽头   cur.next.next是指判断当前数字的后一个数字是否和在后面的一个数字重复假设就剩一个数字  则不会重复
    while (null != cur.next && null != cur.next.next) {
        // cur指的是确定没有重复元素的最后一个
        if (cur.next.val == cur.next.next.val) {
            int x = cur.next.val;
            // 去重 因为不止有两个所以需要用while来判断去重
            while (null != cur.next && x == cur.next.val) {
                cur.next = cur.next.next;
            }
        } else {
            cur = cur.next;
        }
    }

    return dum.next;
}
```

### 9、删除链表的节点

```java
public ListNode deleteNode (ListNode head, int val) {
    // write code here
    ListNode cur = head;

    if (val == head.val) {
        head = head.next;
    }

    while (null != cur) {
        if (val == cur.next.val) {
            cur.next = cur.next.next;
        } else {
            cur = cur.next;
        }
    }

    return head;
}
```

### 10、用两个栈实现队列

```java
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
```

### 11、包含min函数的栈

```java
public class 包含min函数的栈 {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

// 每次不需要都压入min
//    // 只有更小的时候min才会入栈    但是data无论五河都会入栈
//    public void push(int node) {
//        if (stackMin.isEmpty()) {
//            stackMin.push(node);
//        } else if (stackMin.peek() >= node){
//            stackMin.push(node);
//        }
//        stackData.push(node);
//    }
//
//    public void pop() {
//        int val = stackData.pop();
//        if (val == stackMin.peek()) {
//            stackMin.pop();
//        }
//    }
//
//    public int top() {
//        return stackData.peek();
//    }
//
//    public int min() {
//        return stackMin.peek();
//    }

    public void push(int node) {
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else {
            if (stackMin.peek() >= node) {
                stackMin.push(node);
            } else {
                stackMin.push(stackMin.peek());
            }
        }
        stackData.push(node);
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.pop();
    }

    public int min() {
        return stackMin.peek();
    }
}
```

### 12、 **栈的压入、弹出序列**

```java
public boolean IsPopOrder(int [] pushA,int [] popA) {
    Stack<Integer> stack = new Stack<>();
    int i = 0;
    int j = 0;
    while (i < pushA.length) {
        if (pushA[i] != popA[j]) {
            stack.push(pushA[i++]);
        } else {
            ++i;
            ++j;
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
    }
    return stack.isEmpty();
}
```
