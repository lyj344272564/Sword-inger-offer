# 剑指offer

---

### [剑指 Offer 03. 数组中重复的数字](https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/)

````java
class Solution {
    public int findRepeatNumber(int[] nums) {
        int i=0;
        while (i<nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[i]==nums[nums[i]]) {
                return nums[i];
            }
            swap(nums,nums[i],i);
        }
        return -1;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
````

### [剑指 Offer 04. 二维数组中的查找](https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/)

````java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (0==matrix.length || 0 == matrix[0].length) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n-1;
        while (i<m && j>=0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
````

### [剑指 Offer 05. 替换空格](https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/)

````java
class Solution {
    public String replaceSpace(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' '){
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
````

### [剑指 Offer 06. 从尾到头打印链表](https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/)

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] reversePrint(ListNode head) {
        if (null == head) return new int[]{};
        ListNode cur = head;
        Stack<Integer> stack = new Stack<>();
        while (cur!=null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        int cnt = 0;
        while (!stack.isEmpty()) {
            res[cnt++] = stack.pop();
        }
        return res;
    }
}
````

### [剑指 Offer 07. 重建二叉树](https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return builderTree(preorder,0,inorder,0,inorder.length-1);
    }
    public TreeNode builderTree(int[] preorder, int preIndex, int[] inorder,int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        int val = preorder[preIndex];
        int inIndex = map.get(val);
        TreeNode root = new TreeNode(val);
        int leftNum = inIndex - inStart;
        root.left = builderTree(preorder,preIndex+1,inorder,inStart,inIndex-1);
        root.right = builderTree(preorder,preIndex+1+leftNum,inorder,inIndex+1,inEnd);
        return root;
    }
}
````

### [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)

````java
class CQueue {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public CQueue() {

    }
    
    public void appendTail(int value) {
        s1.push(value);
    }
    
    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (s2.isEmpty()) {
            return -1;
        } else {
            return s2.pop();
        }
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
````

### [剑指 Offer 10- I. 斐波那契数列](https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/)

````java
class Solution {
    public int fib(int n) {
        if (0 == n) return 0;
        if (n <= 2) return 1;
        int a = 1;
        int b = 1;
        for (int i=2; i<=n; i++) {
            int c = (a+b)%1000000007;
            a = b;
            b = c;
        }
        return a;
    }
}
````

### [剑指 Offer 10- II. 青蛙跳台阶问题](https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/)

````java
class Solution {
    public int numWays(int n) {
        int a = 1;
        int b = 1;
        for (int i=0; i<n; i++) {
            int c = (a+b)%1000000007;
            a = b;
            b = c;
        }
        return a;
    }
}
````

### [剑指 Offer 11. 旋转数组的最小数字](https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/)

````java
class Solution {
    public int minArray(int[] nums) {
        if (0 == nums.length) return -1;
        int n = nums.length - 1;
        while (n>0 && nums[0]==nums[n]) {
            n--;
        }
        if (nums[0] < nums[n]) return nums[0];
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
````

### [剑指 Offer 12. 矩阵中的路径](https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/)

````java
class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (dfs(board,word,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int u, int x, int y) {
        if (x<0||x>board.length || y<0||y>board[0].length || word.charAt(u)!=board[x][y]) {
            return false; 
        }
        if (u == word.length()-1) return true;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        char c = board[x][y];
        board[x][y] = '*';
        for (int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a>=0 && a<board.length && b>=0 && b<board[0].length && board[a][b]!='*') {
                if (dfs(board,word,u+1,a,b)) {
                    return true;
                }
            }
        }
        board[x][y] = c;
        return false;
    }
}
````

### [剑指 Offer 13. 机器人的运动范围](https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/)

````java
class Solution {
    boolean[][] st = new boolean[105][105];
    public int movingCount(int m, int n, int k) {
        int res = 0;
        if (0==m || 0==n) return res;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        st[0][0] = true;
        while (!q.isEmpty()) {
            int[] cc = q.poll();
            int x = cc[0];
            int y = cc[1];
            if (getSum(x,y) > k) {
                continue;
            }
            res++;
            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            for (int i=0; i<4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                if (a>=0&&a<m&&b>=0&&b<n&&st[a][b]==false&&getSum(a,b)<=k) {
                    q.offer(new int[]{a,b});
                    st[a][b] = true;
                }
            }
        }
        return res;
    }
    int getSumGG(int x) {
        int sum = 0;
        while (x>0) {
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
    int getSum(int x, int y) {
        return getSumGG(x)+getSumGG(y);
    }
}
````

### [剑指 Offer 14- I. 剪绳子](https://leetcode-cn.com/problems/jian-sheng-zi-lcof/)

````java
class Solution {
    public int cuttingRope(int n) {
        if (2 == n) return 1;
        if (3 == n) return 2;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= Integer.MAX_VALUE;
            n -= 3;
        }
        return (int)(res*n%Integer.MAX_VALUE);
    }
}
````

### [剑指 Offer 14- II. 剪绳子 II](https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/)

````java
class Solution {
    public int cuttingRope(int n) {
        if (2 == n) return 1;
        if (3 == n) return 2;
        long res = 1;
        while (n > 4) {
            res *= 3;
            res %= 1000000007;
            n -= 3;
        }
        return (int)(res*n%1000000007);
    }
}
````

### [剑指 Offer 15. 二进制中1的个数](https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/)

````java
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (0 != n) {
            res += n&1;
            n >>>= 1;
        }
        return res;
    }
}
````

### [剑指 Offer 16. 数值的整数次方](https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

````java
class Solution {
    public double myPow(double x, int n) {
        if (0 == n) return 1;
        if (1 == n) return x;
        double res = myPow(x,n/2);
        if (n%2 == 0) return res * res;
        else return n<0 ? res*res*1/x : res*res*x;
    }
}
````

### [剑指 Offer 17. 打印从1到最大的n位数](https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/)

````java
class Solution {
    public int[] printNumbers(int n) {
        int cnt = (int)Math.pow(10,n)-1;
        int[] res = new int[cnt];
        for (int i=0; i<cnt; i++) {
            res[i] = i+1;
        }
        return res;
    }
}
````

### [剑指 Offer 18. 删除链表的节点](https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/)

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        ListNode cur = head.next;
        if (pre.val == val) {
            return pre.next;
        }
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return head;
    }
}
````

### [剑指 Offer 21. 调整数组顺序使奇数位于偶数前面](https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/)

````java
class Solution {
    public int[] exchange(int[] nums) {
        if (0 == nums.length) return new int[]{};
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 1) l++;
            if (nums[r] % 2 == 0) r--;
            if (l<r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
            }
        }
        return nums;
    }
}
````

### [剑指 Offer 22. 链表中倒数第k个节点](https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/)

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head) return null;
        ListNode f = head;
        ListNode s = head;
        while (k-- != 0) {
            f = f.next;
        }
        while (f!=null) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
}
````

### [剑指 Offer 24. 反转链表](https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/)

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
````

### [剑指 Offer 25. 合并两个排序的链表](https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/)

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1!=null && h2!=null) {
            if (h1.val<=h2.val) {
                dum.next = h1;
                h1 = h1.next;
            } else {
                dum.next = h2;
                h2 = h2.next;
            }
            dum = dum.next;
        }
        dum.next = h1==null?h2:h1;
        return cur.next;
    }
}
````

### [剑指 Offer 26. 树的子结构](https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null || B==null) return false;
        return isSub(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    public boolean isSub(TreeNode a, TreeNode b) {
        if (b == null) return true;
        if (a == null) return false;
        if (a.val != b.val) return false;
        return isSub(a.left,b.left) && isSub(a.right,b.right);
    }
}
````

### [剑指 Offer 27. 二叉树的镜像](https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (null != t.right) stack.push(t.right);
            if (null != t.left) stack.push(t.left);
            TreeNode tmp = t.right;
            t.right = t.left;
            t.left = tmp;
        }
        return root;
    }
}
````

### [剑指 Offer 28. 对称的二叉树](https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        return dfs(root.left, root.right);
    }
    public boolean dfs(TreeNode l, TreeNode r) {
        if (null==l || null==r) return null==l&&null==r;
        if (l.val != r.val) return false;
        return dfs(l.left,r.right) && dfs(l.right,r.left);
    }
}
````

### [剑指 Offer 29. 顺时针打印矩阵](https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/)

````java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (0==matrix.length ||  0==matrix[0].length) return new int[]{};
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int top = 0;
        int right = cols - 1;
        int bottom = rows - 1;
        int[] res = new int[cols*rows];
        int cnt = 0;
        while (left<=right && top<=bottom) {
            for (int i=left; i<=right; i++) {
                res[cnt++] = matrix[top][i];
            }
            for (int i=top+1; i<=bottom; i++) {
                res[cnt++] = matrix[i][right];
            }
            if (left<right && top<bottom) {
                for (int i=right-1; i>=left; i--) {
                    res[cnt++] = matrix[bottom][i];
                }
                for (int i=bottom-1; i>top; i--) {
                    res[cnt++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
````

### [剑指 Offer 30. 包含min函数的栈](https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/)

````java
class MinStack {

    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x <= min()) {
            stackMin.push(x);
        }
        stackData.push(x);
    }
    
    public void pop() {
        if (stackData.pop() == min()) {
            stackMin.pop();
        }
    }
    
    public int top() {
        return stackData.peek();
    }
    
    public int min() {
        return stackMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
````

### [剑指 Offer 31. 栈的压入、弹出序列](https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/)

````java
class Solution {
    public boolean validateStackSequences(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i++]);
            } else {
                ++i;
                ++j;
                while (!stack.isEmpty() && stack.peek()==popA[j]) {
                    stack.pop();
                    ++j;
                }
            }
        }
        return stack.isEmpty();
    }
}
````

### [剑指 Offer 32 - II. 从上到下打印二叉树 II](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (null == root) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode t = q.poll();
                temp.add(t.val);
                if (null != t.left) q.offer(t.left);
                if (null != t.right) q.offer(t.right);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
````

### [剑指 Offer 32 - III. 从上到下打印二叉树 III](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (null == root) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = q.size();
            for (int i=0; i<size; i++) {
                TreeNode t = q.poll();
                temp.add(t.val);
                if (null != t.left) q.offer(t.left);
                if (null != t.right) q.offer(t.right);
            }
            if (flag) {
                Collections.reverse(temp);
            }
            flag = !flag;
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
}
````

### [剑指 Offer 33. 二叉搜索树的后序遍历序列](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/)

````java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verify(postorder, 0, postorder.length-1);
    }
    public boolean verify(int[] q, int i, int j) {
        if (i>=j) return true;
        int mid = i;
        while (q[mid] < q[j]) mid++;
        int root = mid;
        while (q[root] > q[j]) root++;
        if (root != j) return false;
        return verify(q,i,mid-1) && verify(q,mid,j-1);
    }
}
````

### [剑指 Offer 34. 二叉树中和为某一值的路径](https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root,target);
        return res;
    }
    public void dfs(TreeNode root, int target) {
        if (null == root) return ;
        temp.add(root.val);
        if (target == root.val && null == root.left && null==root.right) {
            res.add(new ArrayList<>(temp));
        }
        dfs(root.left,target-root.val);
        dfs(root.right,target-root.val);
        temp.remove(temp.size()-1);
    }
}
````

### [剑指 Offer 35. 复杂链表的复制](https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/)

````java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null) {
            map.put(cur,new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
````

### [剑指 Offer 36. 二叉搜索树与双向链表](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/)

````java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre;
    Node head;
    public Node treeToDoublyList(Node root) {
        if (null == root) return null;
        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    public void dfs(Node root) {
        if (root!=null) {
            treeToDoublyList(root.left);
            if (null == pre) {
                head = root;
            } else {
                root.left = pre;
                pre.right = root;
            }
            pre = root;
            treeToDoublyList(root.right);
        }
    }
}
````

### [剑指 Offer 37. 序列化二叉树](https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (null == root) return "#";
        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pollLast();
            if (null == t) {
                sb.append("#").append(",");
            } else {
                sb.append(t.val).append(",");
                stack.offerLast(t.right);
                stack.offerLast(t.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(q);
    }
    public TreeNode buildTree(Deque<String> q) {
        String s = q.poll();
        if ("#".equals(s)) return null;
        int val = Integer.parseInt(s);
        TreeNode root = new TreeNode(val);
        root.left = buildTree(q);
        root.right = buildTree(q);
        return root;
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
````

### [剑指 Offer 38. 字符串的排列](https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/)

````java
class Solution {
    ArrayList<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }
    public void dfs(int u) {
        if (u == c.length-1) {
            res.add(String.valueOf(c));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=u; i<c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i,u);
            dfs(u+1);
            swap(i,u);
        }
    }
    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}
````

### [剑指 Offer 39. 数组中出现次数超过一半的数字](https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/)

````java
class Solution {
    public int majorityElement(int[] nums) {
        int leader = 0;
        int cnt = 0;
        for (int x : nums) {
            if (0 == cnt) {
                leader = x;
            }
            cnt += x == leader ? 1 : -1;
        }
        return leader;
    }
}
````

### [剑指 Offer 40. 最小的k个数](https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/)

````java
class Solution {
    int[] temp;
    public int[] getLeastNumbers(int[] arr, int k) {
        temp = new int[arr.length];
        merge_sort(arr,0,arr.length-1);
        int[] res = new int[k];
        System.arraycopy(arr,0,res,0,k);
        return res;
    }
    public void merge_sort(int[] q, int l, int r) {
       if (l >= r) return;
       int mid = l + r >> 1;
       merge_sort(q,l,mid);
       merge_sort(q,mid+1,r);
       int k = 0;
        int i=l;
        int j = mid+1;
        while (i<=mid && j<=r) {
            if (q[i] <= q[j]) {
                temp[k++] = q[i++];
            } else {
                temp[k++] = q[j++];
            }
        }
        while (i<=mid) {
            temp[k++] = q[i++];
        }
        while (j<=r) {
            temp[k++] = q[j++];
        }
        for (i=l,j=0; i<=r; i++,j++) {
            q[i] = temp[j];
        }
    }
}
````

### [剑指 Offer 41. 数据流中的中位数](https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/)

````java
class MedianFinder {
    Queue<Integer> A,B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x,y)->(y-x));
    }
    
    public void addNum(int num) {
        if (A.size() != B.size()) {
                        A.add(num);
            B.add(A.poll());

        } else {
            B.add(num);
            A.add(B.poll()); 
        }
    }
    
    public double findMedian() {
        return A.size()!=B.size() ? A.peek() : (A.peek()+B.peek())/2.0; 
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
````

### [剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)

````java
class Solution {
    public int maxSubArray(int[] nums) {
        int s = 0;
        int res = Integer.MIN_VALUE;
        for (int x : nums) {
            if (s < 0) {
                s = 0;
            }
            s += x;
            res = Math.max(res,s);
        }
        return res;
    }
}
````

### [剑指 Offer 43. 1～n 整数中 1 出现的次数](https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/)

````java
class Solution {
    public int countDigitOne(int n) {
        return hasOne(n);
    }
    public int hasOne(int n) {
        if (0 == n) {
            return  0;
        }
        String number = String.valueOf(n);
        int high = number.charAt(0) - '0';
        int pow = (int)(Math.pow(10,number.length()-1));
        int left = n - high*pow;
        if (1 == high) {
            return hasOne(pow-1) + left+1 + hasOne(left);
        } else {
            return hasOne(pow-1)*high + pow + hasOne(left);
        }
    }
}
````

### [剑指 Offer 44. 数字序列中某一位的数字](https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/)

````java
class Solution {
    public int findNthDigit(int n) {
        int i = 1;
        long s = 9;
        int base = 1;
        while (n > s*i) {
            n -= s*i;
            i++;
            s *= 10;
            base *= 10;
        }
        long num = base + (n-1)/i;
        return Long.toString(num).charAt((n-1)%i)-'0';
    }
}
````

### [剑指 Offer 45. 把数组排成最小的数](https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/)

````java
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int i = 0;
        for (int x : nums) {
            strs[i++] = String.valueOf(x);
        }
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
}
````

### [剑指 Offer 46. 把数字翻译成字符串](https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/)

````java
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (0 == s.length()) return 0;
        if (s.length() < 2) return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = (s.charAt(0)=='1'||s.charAt(0)=='2'&&s.charAt(1)>=0&&s.charAt(1)<='5') ? 2 : 1;
        for (int i=2; i<s.length(); i++) {
            if (s.charAt(i-1)=='1'||s.charAt(i-1)=='2'&&s.charAt(i)>=0&&s.charAt(i)<='5') dp[i] = dp[i-1] + dp[i-2];
            else dp[i] = dp[i-1];
        } 
        return dp[s.length()-1];
    }
}
````

### [剑指 Offer 47. 礼物的最大价值](https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/)

````java
class Solution {
    public int maxValue(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        dp[0][0] = grid[0][0];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[n][m];
    }
}
````

### [剑指 Offer 48. 最长不含重复字符的子字符串](https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/)

````java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0,j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i,map.get(c)+1);
            }
            len = Math.max(len,j-i+1);
            map.put(c,j);
        }
        return len;
    }
}
````

### [剑指 Offer 49. 丑数](https://leetcode-cn.com/problems/chou-shu-lcof/)

````java
class Solution {
    public int nthUglyNumber(int n) {
        if (0 == n) return 0;
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            int min = Math.min(n1,Math.min(n2,n3));
            dp[i] = min;
            if (n1 == min) a++;
            if (n2 == min) b++;
            if (n3 == min) c++;
        }
        return dp[n-1];
    }
}
````

### [剑指 Offer 50. 第一个只出现一次的字符](https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/)

````java
class Solution {
    public char firstUniqChar(String s) {
        if (s.length()==0) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c,map.get(c)+1);
            } else {
                map.put(c,1);
            }
        }
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return c;
        }
        return ' ';
    }
}
````

### [剑指 Offer 51. 数组中的逆序对](https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/)

````java
class Solution {
    int[] temp;
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return merger(nums,0,nums.length-1);
    }
    public int merger(int[] q, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + r >> 1;
        int res = merger(q,l,mid) + merger(q,mid+1,r);
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i<=mid && j<=r) {
            if (q[i]<=q[j]) {
                temp[k++] = q[i++];
            } else {
                temp[k++] = q[j++];
                res += mid-i+1;
                // res %= 1000000007;
            }
        }
        while (i<=mid) {
            temp[k++] = q[i++];
        }
        while (j<=r) {
            temp[k++] = q[j++];
        }
        for (i=l,j=0;i<=r; i++,j++) {
            q[i] = temp[j];
        }
        return res;
    }
}
````

### [剑指 Offer 52. 两个链表的第一个公共节点](https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/)

````java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a==null? headB : a.next;
            b = b==null? headA : b.next;
        }
        return a;
    }
}
````

### [剑指 Offer 53 - I. 在排序数组中查找数字 I](https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/)

````java
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (0 == n) return 0;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        } 
        int L = l;
        if (nums[l] != target) {
            return 0;
        }
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r - L + 1;
    }
}
````

### [剑指 Offer 53 - II. 0～n-1中缺失的数字](https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/)

````java
class Solution {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + r + 1 >> 1;
            if(nums[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
````

### [剑指 Offer 54. 二叉搜索树的第k大节点](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        mergeTranfances(root);
        return res.get(res.size()-k);
    }
    public void mergeTranfances(TreeNode root) {
        if (null == root) return ;
        mergeTranfances(root.left);
        res.add(root.val);
        mergeTranfances(root.right);
    }
}
````

### [剑指 Offer 55 - I. 二叉树的深度](https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
````

### [剑指 Offer 55 - II. 平衡二叉树](https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (null == root) return true;
        int lh = dfs(root.left);
        int rh = dfs(root.right);
        return Math.abs(lh-rh)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int dfs(TreeNode root) {
        if (null == root) return 0;
        return Math.max(dfs(root.left),dfs(root.right))+1;
    }
}	
````

### [剑指 Offer 56 - I. 数组中数字出现的次数](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/)

````java
class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res ^= x;
        }
        int mask = 1;
        // 寻找最右面的 1
        while (0 == (mask&res)) {
            mask <<= 1;
        }
        int a = 0;
        int b = 0;
        for (int x : nums) {
            if (0 == (mask&x)) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        return new int[]{a,b};
    }
}
````

### [剑指 Offer 56 - II. 数组中数字出现的次数 II](https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/)

````java
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x,0)+1);
        }
        for (int x : nums) {
            if (1 == map.get(x)) {
                return x;
            }
        }
        return 0;
    }
}
````

### [剑指 Offer 57. 和为s的两个数字](https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/)

````java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i=0,j=nums.length-1; i<=j;) {
            if (nums[i] + nums[j] == target) {
                return new int[]{nums[i],nums[j]};
            } else if (nums[i] + nums[j] < target){
                i++;
            } else {
                j--;
            }
        }
        return new int[]{0,0};
    }
}
````

### [剑指 Offer 57 - II. 和为s的连续正数序列](https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/)

````java
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        for (int l=1,r=2; l<r; ) {
            int sum = (l+r) * (r-l+1) / 2;
            if (sum == target) {
                int[] level = new int[r-l+1];
                for (int i=l; i<=r; i++) {
                    level[i-l] = i;
                }
                res.add(level);
                l++;
            } else if (sum < target) {
                r++;
            } else {
                l++;
            }
            
        }
        return res.toArray(new int[res.size()][]);
    }
}
````

### [剑指 Offer 58 - I. 翻转单词顺序](https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/)

````java
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=strs.length-1; i>=0; i--) {
            if (strs[i].equals("")) continue;
            sb.append(strs[i]).append(" ");
        }
        return sb.toString().trim();
    }
}
````

### [剑指 Offer 58 - II. 左旋转字符串](https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/)

````java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}
````

### [剑指 Offer 59 - I. 滑动窗口的最大值](https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/)

````java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        if (0 == nums.length) return new int[]{};
        LinkedList<Integer> qmax = new LinkedList<>();
        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (i-k == qmax.peekFirst()) {
                qmax.pollFirst();
            }
            if (i >= k-1) {
                res[cnt++] = nums[qmax.peekFirst()];
            }
        }
        return res;
    }
}
````

### [剑指 Offer 59 - II. 队列的最大值](https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/)

````java
class MaxQueue {
    LinkedList<Integer> q1 = new LinkedList<>();
    LinkedList<Integer> q2 = new LinkedList<>();

    public MaxQueue() {

    }
    
    public int max_value() {
        return q2.isEmpty()?-1:q2.peekFirst();
    }
    
    public void push_back(int value) {
        q1.add(value);
        while (!q2.isEmpty() && q2.peekLast() < value) {
            q2.pollLast();
        }
        q2.add(value);
    }
    
    public int pop_front() {
        int temp = q1.isEmpty() ? -1 : q1.pollFirst();
        if (!q2.isEmpty() && temp==q2.peekFirst()) {
            q2.pollFirst();
        }
        return temp;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
````

### [剑指 Offer 60. n个骰子的点数](https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/)

````java
class Solution {
    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp,1.0/6.0);
        for (int i=2; i<=n; i++) {
            double[] tmp = new double[i*5+1];
            for (int j=0; j<dp.length; j++) {
                for (int k=0; k<6; k++) {
                    tmp[j+k] += dp[j]/6.0;
                }
            }
            dp = tmp;
        }
        return dp;
    }
}
````

### [剑指 Offer 61. 扑克牌中的顺子](https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/)

````java
class Solution {
    public boolean isStraight(int[] nums) {
        if (0 == nums.length) return false;
        Arrays.sort(nums);
        int idx = 0;
        while (0 == nums[idx]) idx++;
        for (int i=idx; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) return false;
        }
        return nums[nums.length-1]-nums[idx] <= 4;
    }
}
````

### [剑指 Offer 62. 圆圈中最后剩下的数字](https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/)

````java
class Solution {
    public int lastRemaining(int n, int m) {
        if (0 == n) return 0;
        return (lastRemaining(n-1,m)+m)%n;
    }
}
````

### [剑指 Offer 63. 股票的最大利润](https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/)

````java
class Solution {
    public int maxProfit(int[] prices) {
        if (0 == prices.length) return 0;
        int res = 0;
        for (int i=0,min=Integer.MAX_VALUE; i<prices.length; i++) {
            res = Math.max(res,prices[i]-min);
            min = Math.min(min,prices[i]);
        }
        return res;
    }
}
````

### [剑指 Offer 64. 求1+2+…+n](https://leetcode-cn.com/problems/qiu-12n-lcof/)

````java
class Solution {
    public int sumNums(int n) {
        boolean b = (n>1) && (n+=sumNums(n-1))==0;
        return n;
    }
}
````

### [剑指 Offer 65. 不用加减乘除做加法](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)

````java
class Solution {
    public int add(int a, int b) {
        while (b != 0) {
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
````

### [剑指 Offer 66. 构建乘积数组](https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu-lcof/)

````java
class Solution {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for (int i=0,n=1; i<a.length; i++) {
            b[i] = n;
            n *= a[i];
        }
        for (int i=a.length-1,n=1; i>=0; i--) {
            b[i] *= n;
            n *= a[i];
        }
        return b;
    }
}
````

### [剑指 Offer 67. 把字符串转换成整数](https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/)

````java
class Solution {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (0 == chars.length) return 0;
        boolean positive = true;
        int start = 1;
        if ('-' == chars[0]) {
            positive = false;
        } else if ('+'!=chars[0]) {
            start = 0;
        }
        long res = 0;
        for (int i=start; i<chars.length; i++) {
            if (chars[i]<'0' || chars[i]>'9') break;
            res = res*10 + (chars[i]-'0');
            if (res>Integer.MAX_VALUE) {
                return positive?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
        }
        return positive?(int)res:(int)(-1*res);
    }
}
````

### [剑指 Offer 68 - I. 二叉搜索树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null) {
            if (p.val<root.val && q.val<root.val) {
                root = root.left;
                continue;
            }
            if (p.val>root.val && q.val>root.val) {
                root = root.right;
                continue;
            }
            return root;
        }
        return root;
    }
}
````

### [剑指 Offer 68 - II. 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return help(root,p,q);
    }
    public TreeNode help(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) {
            return root;
        }
        TreeNode l = help(root.left,p,q);
        TreeNode r = help(root.right,p,q);
        if (null == l) {
            return r;
        }
        if (null == r) {
            return l;
        }
        return root;
    }
}
````

### [面试题19. 正则表达式匹配](https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/)

````java
class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=m; j++) {
                if (j == 0) dp[i][j] = i==0;
                else {
                    if (p.charAt(j-1)!='*') {
                        if (i>0 && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')) {
                            dp[i][j] = dp[i-1][j-1];
                        }
                    } else {
                        if (j>=2) dp[i][j] |= dp[i][j-2];
                        if (i>=1 && j>=2 && (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.')) {
                            dp[i][j] |= dp[i-1][j];
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }
}
````

### [面试题32 - I. 从上到下打印二叉树](https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/)

````java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) return new int[]{};
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            res.add(t.val);
            if (null != t.left) q.offer(t.left);
            if (null != t.right) q.offer(t.right);
        }
        int[] ans = new int[res.size()];
        for (int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
````



