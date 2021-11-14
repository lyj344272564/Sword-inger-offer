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

### 24、判断是不是平衡二叉树

```java
public class 判断是不是平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }

        int lh = dfs(root.left);
        int rh = dfs(root.right);

        return Math.abs(lh-rh)<=1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(dfs(root.left),dfs(root.right)) + 1;
    }
}
```

### 25、**二叉树的下一个结点**

```java
public TreeLinkNode GetNext(TreeLinkNode p) {
    // 有右儿子 则有儿子的最左儿子就是下一个
    if (null != p.right) {
        p = p.right;
        while (null != p.left) {
            p = p.left;
        }
        return p;
    }
    // 若没有右儿子 则判断这个点是不是父节点的右节点是的话那就一直往上找知道找到第一个不是右  则返回他的父节点
    while (null!=p.next && p==p.next.right) {
        p = p.next;
    }
    return p.next;
}
```

### 26、对称的二叉树

```java
public class 对称的二叉树 {

    boolean isSymmetrical(TreeNode root) {
        if (null == root) {
            return true;
        }
        return dfs(root.left,root.right) && dfs(root.right,root.left);
    }

    public boolean dfs(TreeNode l, TreeNode r) {
        if (null==l || null==r) {
            return null==l&&null==r;
        }
        if (l.val != r.val) {
            return false;
        }
        return dfs(l.left,r.right) && dfs(l.right,r.left);
    }
}
```

### 27、把二叉树打印成多行

```java
ArrayList<ArrayList<Integer>> Print(TreeNode root) {
   
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    if (null == root) {
        return res;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

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
        res.add(level);
    }
    return res;
}
```

### 28、序列化二叉树

```java
public class 序列化二叉树 {
    
    String Serialize(TreeNode root) {
        if (null == root) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pollLast();
            if (null == t) {
                sb.append("#").append(",");
            } else {
                sb.append(t.val).append(",");
                // 因为要取最后一个所以先添加right
                stack.offerLast(t.right);
                stack.offerLast(t.left);
            }
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
        return buildTree(queue);
    }

    TreeNode buildTree(Deque<String> queue) {
        String s = queue.poll();
        if ("#".equals(s)) {
            return null;
        }
        int val = Integer.parseInt(s);
        TreeNode root = new TreeNode(val);
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
```

### 29、二叉树中和为某一值的路径三

```java
public int key = 0;

public int FindPath (TreeNode root, int sum) {
    // write code here
    if (null == root) {
        return key;
    }
    dfs(root,sum);
    FindPath(root.left,sum);
    FindPath(root.right,sum);

    return key;
}

public void dfs(TreeNode root, int sum) {
    if (null == root) {
        return;
    }
    sum -= root.val;
    if (0 == sum) {
        key++;
    }
    dfs(root.left, sum);
    dfs(root.right, sum);
}
```

### 30、在二叉树中找到两个节点的最近公共祖先

```java
public class 在二叉树中找到两个节点的最近公共祖先 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return helper(root,o1,o2).val;
    }

    public TreeNode helper(TreeNode root, int o1, int o2) {
        if (null==root || root.val==o1 || root.val==o2) {
            return root;
        }
        TreeNode l = helper(root.left,o1,o2);
        TreeNode r = helper(root.right,o1,o2);
        //如果left为空，说明这两个节点在root结点的右子树上，我们只需要返回右子树查找的结果即可
        if (null == l) {
            return r;
        }
        if (null == r) {
            return l;
        }
        //如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        //我们只需要返回cur结点即可。
        return root;
    }
}
```

### 31、二维数组中的查找

```java
public boolean Find(int target, int [][] array) {
    int n = array.length;
    int m = array[0].length;

    int i = 0;
    int j = m - 1;
    while (i<n && j>=0) {
        if (array[i][j] == target) {
            return true;
        } else if (array[i][j] < target){
            i++;
        } else {
            j--;
        }
    }
    return false;
}
```

### 32、数字在升序数组中出现的次数

```java
public int GetNumberOfK(int [] array , int k) {
    if (0 == array.length) {
        return 0;
    }
    int[] res = new int[2];
    int l = 0;
    int r = array.length - 1;

    while (l<r) {
        int mid = l + r >> 1;
        if (array[mid] >= k) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }

    if (array[l] != k) {
        return 0;
    }
    int L = l;
    l = 0;
    r = array.length - 1;
    while (l<r) {
        int mid = l + r + 1 >> 1;
        if (array[mid] <= k) {
            l = mid;
        } else {
            r = mid - 1;
        }
    }
    return r-L+1;
}
```

### 33、滑动窗口的最大值

```java
public ArrayList<Integer> maxInWindows(int [] num, int k) {
    ArrayList<Integer> res = new ArrayList<>();
    if (null == num || k<1 || k>num.length) {
        return res;
    }
    // 存储的是下标
    LinkedList<Integer> qmax = new LinkedList<>();

    for (int i=0; i<num.length; i++) {
        while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
            qmax.pollLast();
        }
        qmax.addLast(i);
        // 判断窗口大小
        if (qmax.peekFirst() == i-k) {
            qmax.pollFirst();
        }
        if (i >= k-1) {
            res.add(num[qmax.peekFirst()]);
        }
    }

    return res;
}
```

### 34、翻转单词序列

```java
public String ReverseSentence(String str) {
    String[] s = str.split(" ");
    List<String> list = new ArrayList<>();

    for (int i=0; i<s.length; i++) {
        list.add(s[i]);
    }

    Collections.reverse(list);
    StringBuilder sb = new StringBuilder();

    for (int i=0; i<list.size(); i++) {
        if (i < list.size()-1) {
            sb.append(list.get(i) + " ");
        } else {
            sb.append(list.get(i));
        }
    }

    return sb.toString();
}
```

### 35、旋转数组的最小数字

```java
public int minNumberInRotateArray(int [] array) {
    // 边界
    if (0 == array.length) {
        return -1;
    }
    int n = array.length - 1;
    // 去掉一样的
    while (n>0 && array[n] == array[0]) {
        n--;
    }
    // 判断是否升序
    if (array[n] >= array[0]) {
        return array[0];
    }

    // 二分
    int l = 0;
    int r = n;
    while (l < r) {
        int mid = l + r >> 1;
        if (array[mid] < array[0]) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }

    return array[l];
}
```

### 36、字符串的排列

```java
public class 字符串的排列 {

    ArrayList<String> res  = new ArrayList<>();
    char[] c;

    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        return res;
    }

    public void dfs(int x) {
        if (x == c.length-1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=x; i<c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
```

### 37、数字序列中某一位的数字

```java
public int findNthDigit (int n) {
    // 从1开始但是还有0
    n--;
    // 减去0
    n++;
    int i = 1;
    // 这一位有多少个数
    long s = 9;
    // 这一位数的刚开始的数字
    int base = 1;
    // 确定是几位数
    while (n > i*s) {
        n -= s*i;
        i++;
        s *= 10;
        base *= 10;
    }
    // 确定是几位数的第几个数
    long num = base + (n-1)/i;
    // 属于那个数的第几位
    return Long.toString(num).charAt((n-1)%i)-'0';
}
```

### 38、连续子数组的最大和

```java
public int FindGreatestSumOfSubArray(int[] array) {
    if (null == array) {
        return 0;
    }
    int s = 0;
    int res = Integer.MIN_VALUE;

    for (int x : array) {
       if (s<0) {
           s = 0;
       }
       s+=x;
       res = Math.max(res,s);
    }
    return res;
}
```

### 39、连续子数组的最大和二

```java
public int[] FindGreatestSumOfSubArray (int[] array) {
    // write code here
    int[] dp = new int[array.length];

    dp[0] = array[0];

    int maxLength = 1;
    int maxSum = array[0];
    int left = 0;
    int right = 0;
    int snapLeft = 0;
    int snapRight = 0;

    for (int i=1; i<=array.length-1; i++) {
        right++;
        // 比较当前和前一个比较
        dp[i] = Math.max(array[i]+dp[i-1],array[i]);
        // 只要dp[i-1]小于0那么就会产生一次
        if (array[i] + dp[i - 1] < array[i]) {
            left = right;
        }
        if (dp[i]>maxSum || dp[i]==maxSum && (right-left+1)>maxLength) {
            snapLeft = left;
            snapRight = right;
            maxLength = right - left + 1;
            maxSum = dp[i];
        }
    }

    int[] res = new int[maxLength];
    int idx = 0;
    for (int i=snapLeft; i<=snapRight; i++) {
        res[idx++] = array[i];
    }

    return res;

}
```

### 40、跳台阶

```java
public int jumpFloor(int target) {
    if (target <= 1) {
        return 1;
    }
    return jumpFloor(target-1) + jumpFloor(target-2);
}
```

### 41、斐波那契数列

```java
public int Fibonacci(int n) {
    int a = 1;
    int b = 1;

    for (int i=2; i<=n; i++) {
        int c = a + b;
        a = b;
        b = c;
    }

    return a;
}
```

### 42、买卖股票的最好时机1

```java
public int maxProfit (int[] prices) {
    // write code here
    int res = 0;
    for (int i=0,min=Integer.MAX_VALUE; i<prices.length; i++) {
        res = Math.max(res,prices[i]-min);
        min = Math.min(prices[i],min);
    }
    return res;
}
```

### 43、礼物的最大价值

```java
public int maxValue (int[][] grid) {
    // write code here

    int n = grid.length;
    int m = grid[0].length;

    int[][] f = new int[n+1][m+1];

    for (int i=1; i<=n; i++) {
        for (int j=1; j<=m; j++) {
            f[i][j] = Math.max(f[i-1][j],f[i][j-1]) + grid[i-1][j-1];
        }
    }

    return f[n][m];
}
```

### 44、最长不含重复字符的子字符串

```java
public int lengthOfLongestSubstring (String s) {
    int len = 0;
    Map<Character,Integer> map = new HashMap<>();
    for (int i=0,j=0; j<s.length(); j++) {
        char c = s.charAt(j);
        if (map.containsKey(c)) {
            i = Math.max(i, map.get(c)+1);
        }
        len = Math.max(len,j-i+1);
        map.put(c,j);
    }
    return len;
}
```

### 45、
