//1.isValidBST  [98 leetcode]
import java.util.*;
public class BooleanTree{
public boolean isValidBST(TreeNode root){
    return helper(root,Long.MIN_VALUE,Long.MAX_VALUE);
}
private boolean helper(TreeNode root,long min,long max){
    if(root==null) return true; //base case
    if(root.val<=min || root.val >=max) return false; //do action on current node
    boolean left=helper(root.left,min,root.val); //recursion
    boolean right=helper(root.right,root.val,max);
    return left && right;
}

//2.isBalancedTree    [110 leetcode]
public boolean isBalanced(TreeNode root){
    return height(root) !=-1; // height > 1 is means true ,if height is ==-1 is means false
}
private int height(TreeNode root){
    if(root==null) return 0; //base case
    int left=height(root.left); //recursion
    int right=height(root.right);
    if(left == -1 || right == -1 || Math.abs(left-right)>1) return -1; //check balance
    return Math.max(left,right)+1; //merged result
}

//3.isSymmetric: check if a binary tree is a mirror of itself. [101 leetcode]
public boolean isSymmetric(TreeNode root){
    return root==null || isMirror(root.left,root.right);
}
private boolean isMirror(TreeNode t1,TreeNode t2){
    if(t1==null && t2==null){
        return true;                //basecase
    }
    if(t1==null || t2==null){
        return false;
    }
    if(t1.val !=t2.val) return false; //do action
    boolean outer=isMirror(t1.left,t2.right);
    boolean inner=isMirror(t1.right,t2.left);
    return outer && inner;
}

//4.isSame tree: check if two binary trees are identical.  [100 leetcode]
public boolean isSameTree(TreeNode p,TreeNode q){
    if(p==null && q==null){
        return true;
    }                          //base case
    if(p==null || q==null){
        return false;
    }
    if(p.val !=q.val){
        return false;         //do action
    }
    boolean left=isSameTree(p.left,q.left);
    boolean right=isSameTree(p.right,q.right); //recursion call
    return left && right;      //merged results
}

//(or) 4. areMirror:
     boolean areMirror(Node a, Node b) {
        //preorder used in this problems
    // 1️⃣ Base Case
        if (a == null && b == null) return true;   // both null → mirror
        if (a == null || b == null) return false;  // one null, other not → not mirror
    // 2️⃣ Do Action on Current Node
        boolean sameValue = (a.data == b.data); // roots must be equal
    // 3️⃣ Recursive Cases
        boolean leftMirror  = areMirror(a.left,b.right);
        boolean rightMirror = areMirror(a.right,b.left);   
    // 4️⃣ Merge Results
        return sameValue && leftMirror && rightMirror;
    }

//5.hasPath sum: subtract current node value from target, If at a leaf if reamaining sum==node value, Merge [112 leetcode]
public boolean haspath(TreeNode root,int targetSum){
    if(root==null) {
        return false; // base case
    }
    if(root.left==null && root.right==null) {
        return root.val==targetSum;    //do action(check wheather path sum matches targetSum)
    }
    boolean left=haspath(root.left, targetSum-root.val);
    boolean right=haspath(root.right, targetSum-root.val); //recursion
    return left || right;  //merge results(If either side finds a valid path,return true)
}

//6.subtree of another tree [572 leetcode] - check if subroot exists inside root
public boolean isSubtree(TreeNode root,TreeNode subroot){
    if(root==null){
        return false; //basec case
    }
    if(isSametree(root,subroot)) { //if find subroot return true immediately so no need to recurse further
        return true;  // do action
    }    
    boolean left=isSubtree(root.left,subroot);
    boolean right=isSubtree(root.right,subroot);   // recursion
    return left || right;
}
private boolean isSametree(TreeNode p,TreeNode q){
    if(p==null && q==null){
        return true;
    }                          //base case
    if(p==null || q==null){
        return false;
    }
    if(p.val !=q.val){
        return false;         //do action
    }
    boolean left=isSametree(p.left,q.left);
    boolean right=isSametree(p.right,q.right); //recursion call
    return left && right;      //merged results
}

//7.Minimum depth of binary tree [111 leetcode]
// using Integer.MAX_VALUE ensures that if one child is missing,the other child is chosen.
// recursion adds 1 at each non-leaf node(counting current node)
// leaf nodes always return depth=1
public int minDepth(TreeNode root){
    if(root==null){
        return 0; //base case
    }
    if(root.left==null && root.right==null){
        return 1; //do action on current node
    }
    int left=(root.left !=null) ? minDepth(root.left) : Integer.MAX_VALUE;
    int right=(root.right !=null) ? minDepth(root.right) : Integer.MAX_VALUE; //recursion
    return 1+Math.min(left,right); //merged results
}


//8.sum of left leaves [404 leetcode] identify if a node is a left leaf.
public int sumOfLeftLeaves(TreeNode root){
    if(root==null){
        return 0; //base case
    }
    int sum=0;
    if(root.left !=null && root.left.left==null && root.left.right==null){ //do action on leaf nodes
        sum +=root.left.val;
    }
    int l=sumOfLeftLeaves(root.left); //recursion
    int r=sumOfLeftLeaves(root.right);
    return sum+l+r; //merged results
} 

//9.sum of leaf nodes
// l+r => merged results always left and right to cover all node from bottom to top.
// cur+l+r
// Math.max(l+r)
// cur+Math.max(l+r)
    static int leafSum(Node root) {
        if(root==null){
            return 0;//base case
        }
        if(root.left==null && root.right==null){
           return root.data; //do action
        }
        int l=leafSum(root.left);
        int r=leafSum(root.right); //recursion
        return l+r; //merged results
    }
// Base Case → handle null or leaf conditions.
// Action → check if current node is leaf.
// Recursive Case → sum results from left & right.
// Return → combine results and pass upwards.

//10.sum of Binary Tree
    static int sumBT(Node root) {
        if(root==null){
            return 0;
        } //base case
        int curVal=root.data; //do action
        int left=sumBT(root.left); //recursion
        int right=sumBT(root.right);
        return curVal+left+right; //merged result
    }
    
public static void main(String[] args) {
    
}
}
