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

### 8、删除链表中重复的结点

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

### 12、栈的压入、弹出序列

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

### 13、二叉树的深度

```java
public int TreeDepth(TreeNode root) {
    if (null == root) {
        return 0;
    }
    int l = TreeDepth(root.left);
    int r = TreeDepth(root.right);
    return Math.max(l,r) + 1;
}
```

### 14、按之字形顺序打印二叉树

```java
public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (null == root) {
        return res;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    boolean flag = false;
    while (!q.isEmpty()) {
        int size = q.size();
        ArrayList<Integer> level = new ArrayList<>();
        for (int i=0; i<size; i++) {
            TreeNode t = q.poll();
            level.add(t.val);
            if (null != t.left) {
                q.offer(t.left);
            }
            if (null != t.right) {
                q.offer(t.right);
            }
        }
        if (flag) {
            Collections.reverse(level);
        }
        flag = !flag;
        res.add(level);
    }
    return res;
}
```

### 15、二叉搜索树的第k个结点

```java
TreeNode KthNode(TreeNode root, int k) {
    List<Integer> res = new ArrayList<>();

    if (null == root || k < 1) {
        return null;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()) {
        TreeNode t = q.poll();
        res.add(t.val);
        if (null != t.left) {
            q.offer(t.left);
        }
        if (null != t.right) {
            q.offer(t.right);
        }
    }

    if (res.size() < k) {
        return null;
    }
    Collections.sort(res);


    return new TreeNode(res.get(k-1));
}
```

### 16、重建二叉树

```java
public class 重建二叉树 {

    //key是中序遍历的值，value是中序遍历的结果  （下标）
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] preorder,int [] inorder) {
        //保存中序遍历的信息
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return createTree(preorder,0,inorder,0,inorder.length-1);
    }
    //preIndex是前序遍历的索引，inStart和inEnd是中序遍历的索引范围
    TreeNode createTree(int[] preorder,int preIndex,int[] inorder,int inStart,int inEnd) {
        // 判断边界
        if (inStart > inEnd) {
            return null;
        }
        //获取前序遍历的值
        int val = preorder[preIndex];
        //获取前序遍历值在中序遍历的位置
        int inIndex = map.get(val);
        //以该值作为根节点的值创建根节点
        TreeNode root = new TreeNode(val);
        //根节点的左子树节点数目
        int leftNum = inIndex - inStart;
        //根节点以左创建左子树，根节点以右创建右子树
        root.left = createTree(preorder,preIndex+1,inorder,inStart,inIndex-1);
        root.right = createTree(preorder,preIndex+1+leftNum,inorder,inIndex+1,inEnd);

        return root;
    }
}
```

### 17、树的子结构

```java
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        //以当前节点为根匹配，或者以左右节点为根匹配
        return isSub(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        //B为空代表匹配完毕
        if (null == B) {
            return true;
        }
        //B非空但A空，匹配失败
        if (null == A) {
            return false;
        }
        //两个节点值不同，匹配失败
        if (A.val != B.val) {
            return false;
        }
        //根节点相同，匹配左右节点
        return isSub(A.left,B.left) && isSub(A.right,B.right);
    }
}
```

### 18、二叉树的镜像

```java
public class 二叉树的镜像 {
// 递归
//    public TreeNode Mirror (TreeNode root) {
//        if (null == root) {
//            return null;
//        }
//
//        Mirror(root.left);
//        Mirror(root.right);
//
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//        return root;
//    }

    // 辅助栈
    public TreeNode Mirror (TreeNode root) {
        if (null == root) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (null != t.left) {
                stack.push(t.left);
            }
            if (null != t.right) {
                stack.push(t.right);
            }
            TreeNode temp = t.right;
            t.right = t.left;
            t.left = temp;
        }

        return root;
    }

}
```

### 19、从上往下打印二叉树

```java
public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

    ArrayList<Integer> res = new ArrayList<>();

    if (null == root) {
        return res;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
        TreeNode t = q.poll();
        res.add(t.val);
        if (null != t.left) {
            q.offer(t.left);
        }
        if (null != t.right) {
            q.offer(t.right);
        }
    }

    return res;

}
```

### 20、二叉搜索树的后序遍历序列

```java
// 二叉搜索树 根节点比左节点大比右节点小
public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (0 == sequence.length) {
            return false;
        }
        return verify(sequence,0,sequence.length-1);
    }

    public boolean verify(int[] sequence,int i, int j) {
        if (i >= j) {
            return true;
        }
        int mid = i;
        //左-右-根，因此mid相当于找到了第一个右节点
        //例如1，3，2，6，9，7，5，root从1开始遍历到6停止，mid=6,132就是左子树
        while (sequence[mid] < sequence[j]) {
            mid++;
        }
        int root = mid;
        //左-右-根，由于已经开始遍历右子树，如果找到第一个不大于j的值只能是j本身
        //例如1，3，2，6，9，7，5，root从6开始遍历到5停止，root=j
        while (sequence[root] > sequence[j]) {
            root++;
        }
        //例如1，3，2，6，9，2，5，root从6开始遍历到2停止，root!=j,5的右子树有2，肯定不对
        if (root != j) {
            return false;
        }
        return verify(sequence,i,mid-1) && verify(sequence,mid,j-1);
    }

}
```

### 21、 二叉树中和为某一值的路径一

```java
public class 二叉树中和为某一值的路径一 {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (null == root) {
            return false;
        }
        // 深度优先遍历
        return dfs(root,sum);
    }

    public boolean dfs(TreeNode root, int target) {
        // 目标路径不存在，开始回溯
        if (null == root) {
            return false;
        }
        // 更新目标值
        target -= root.val;
        // 当当前节点为叶子节点并且目标路径存在时，返回 true
        if (null==root.left && null==root.right && 0==target) {
            return true;
        }
        // 对左右分支进行 dfs
        return dfs(root.left,target) || dfs(root.right,target);
    }
}
```

### 22、二叉树中和为某一值的路径二

```java
public class 二叉树中和为某一值的路径二 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int sum) {
        help(root,sum);
        return res;
    }

    public void help(TreeNode root, int sum) {
        if (null == root) {
            return ;
        }
        temp.add(root.val);
        // 只有在路径末尾是叶子节点时才添加结果
        if (sum==root.val && null==root.left && null==root.right) {
            res.add(new ArrayList<>(temp));
        }
        help(root.left,sum-root.val);
        help(root.right,sum-root.val);
        temp.remove(temp.size()-1);
    }
}
```

### 23、二叉搜索树与双向链表

```java
public class 二叉搜索树与双向链表 {

    public TreeNode Convert(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode left = rightMost(root.left);
        TreeNode right = leftMost(root.right);

        Convert(root.left);
        Convert(root.right);

        if (null != left) {
            left.right = root;
        }
        root.left = left;

        if (null != right) {
            right.left = root;
        }
        root.right = right;
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

    // 找到最左面的节点
    TreeNode leftMost(TreeNode root) {
        if (null == root) {
            return null;
        }
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

    //找到最右面的节点
    TreeNode rightMost(TreeNode root) {
        if (null == root) {
            return null;
        }
        while (null != root.right) {
            root = root.right;
        }
        return root;
    }

}
```

