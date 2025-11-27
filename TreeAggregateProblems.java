//1️⃣ Height of a Tree:
public int height(TreeNode root) {
    // 1. Base Case
    if (root == null) return 0;
    // 3. Recursive Case
    int left = height(root.left);
    int right = height(root.right);
    // 2. Do Action: nothing extra
    int curHeights=1 + Math.max(left, right)
    // 4. Merge
    return curHeights;
}

//2️⃣ Count Nodes:
public int countNodes(TreeNode root) {
    if (root == null) return 0; // base
    int left = countNodes(root.left);   // recursion
    int right = countNodes(root.right); // recursion
    return 1 + left + right; // merge (count current + children)
}

//3️⃣ Sum of All Nodes:
public int sumNodes(TreeNode root) {
    if (root == null) return 0; // base
    int left = sumNodes(root.left);
    int right = sumNodes(root.right); //recursion
    return root.val + left + right; // merge (include root)
}

//4️⃣ Count Leaf Nodes
public int countLeaves(TreeNode root) {
    if (root == null) return 0; // base case
    if (root.left == null && root.right == null) {
        return 1; // action: leaf found
    }
    int left = countLeaves(root.left); //recursion
    int right = countLeaves(root.right);
    return left + right; // merged results
}

//5️⃣ Diameter of Tree:
int diameter = 0;
public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return diameter;
}
private int depth(TreeNode node) {
    if (node == null) return 0; // base case
    int left = depth(node.left);
    int right = depth(node.right); // recursion
    diameter = Math.max(diameter, left + right); // action
    return 1 + Math.max(left, right); // merge: return height
}

//6️⃣ Maximum Path Sum:
int maxSum = Integer.MIN_VALUE;
public int maxPathSum(TreeNode root) {
    maxGain(root);
    return maxSum;
}
private int maxGain(TreeNode root) {
    if (root == null) return 0; // base
    int left = Math.max(0, maxGain(root.left));
    int right = Math.max(0, maxGain(root.right)); //recursion
    maxSum = Math.max(maxSum, left + right + root.val); // action
    return root.val + Math.max(left, right); // merge
}

//7️⃣ Minimum Depth:
public int minDepth(TreeNode root) {
    if (root == null) return 0; // base
    int left = minDepth(root.left);
    int right = minDepth(root.right); //recursion
    if (left == 0 || right == 0) return 1 + left + right; // action
    return 1 + Math.min(left, right); // merge
}

//8️⃣ Count Nodes with Value Greater than X:
public int countGreater(TreeNode root, int X) {
    if (root == null) return 0; // base
    int left = countGreater(root.left, X);
    int right = countGreater(root.right, X); //recursion
    int action = (root.val > X) ? 1 : 0; // action
    return action + left + right; // merge
}

//9️⃣ Sum of Leaf Nodes:
        10
       /  \
      8    12
     / \
    3   5
public int leafSum(TreeNode root) {
    if (root == null) return 0; // base
    if (root.left == null && root.right == null) {
        return root.val; // action
    }
    int left = leafSum(root.left);
    int right = leafSum(root.right); //recursion
    return left + right; // merge
}

//🔟 Maximum Depth of Left Subtree:
public int leftSubtreeHeight(TreeNode root) {
      // ✅ Base Case (Step 1)
    if (root == null || root.left == null) return 0;

    // ✅ Recursive Case (Step 2)
    // We only care about the left subtree
    return height(root.left);
}
public int height(TreeNode node) {
    // ✅ 1. Base Case
    if (node == null) return 0;

    // ✅ 2. Recursive Case
    int leftHeight = height(node.left);   // go left
    int rightHeight = height(node.right); // go right

    // ✅ 3. Do Action on Current Node
    // current node contributes +1 level

    // ✅ 4. Merge Results
    return 1 + Math.max(leftHeight, rightHeight);
}
// For any tree problem:

// Base Case → Stop when node is null.

// Recursive Case → Recurse on children.

// Do Action on Current Node → Compute current node’s contribution.(compare,swap,count,max,min, add, check, etc.)

// Merge Results → Combine children results to form the answer.

//11. size of binary tree:
public static int getSize(Node node) {
        // code here
        if(node==null){
            return 0; // base case
        }
        int l=getSize(node.left); //recursion call
        int r=getSize(node.right);
        return 1+l+r; //merged results
} //here always left recursive and right recursive call come to merged rwsults

//12. Kth Largest in a BST:
class Solution {
    int count = 0;   // counter for nodes visited
    int ans = -1;    // result

    public int kthLargest(Node root, int k) {
        reverseInorder(root, k);
        return ans;
    }
    private void reverseInorder(Node root, int k) {
        if (root == null || count >= k) return; // base case
        // Step 1: traverse right subtree (larger values)
        reverseInorder(root.right, k);
        // Step 2: visit current node (action)
        count++;
        if (count == k) {
            ans = root.data;
            return; // found result, stop
        }
        // Step 3: traverse left subtree (smaller values)
        reverseInorder(root.left, k);
    }

    // 13. Closest Neighbour in BST:
    public int findMaxFork(Node root, int k) {
        // Base Case
        if(root==null){
            return -1;
        }
        //Do action on current node
        if(root.data==k){
            return root.data; // exact match is the max ≤ k
        }
        //Recursive case
        if(root.data<k){
            int rightAns=findMaxFork(root.right,k);
            //merge results
            return (rightAns != -1) ? rightAns : root.data;
        }
        else{
            return findMaxFork(root.left,k);
        }
    }

    //14. minimum depth of binary tree
    int minDepth(Node root) {
        if(root==null){
            return 0; //base case
        }
        int cur=1; //do action
        int l=minDepth(root.left);
        int r=minDepth(root.right); //recursion
        if (root.left == null) return cur + r;  // only right child exists
        if (root.right == null) return cur + l; // only left child exists
        return cur+ Math.min(l,r); //merged results
    }

    //15. Transform to sumtree:
     public void toSumTree(Node root) {
        // add code here.
        helper(root);
    }
    private int helper(Node root){
        if(root==null){
            return 0;
        } //base case
        int oldValue=root.data; //do action
        int l=helper(root.left);
        int r=helper(root.right); //recursion
        root.data=l+r;
        return root.data+oldValue;//merged results;
    }

    //16. BST keys in a range:
    // Function to return a list of BST elements in a given range.
    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        // code here.
        ArrayList<Integer> res=new ArrayList<>();
        helper(root,low,high,res);
        return res;
    }
    private static void helper(Node root,int low,int high,ArrayList<Integer> res){
        //base case
        if(root==null){
            return;
        }
        //first check because here non decreasing order so first check left recursive call 
        if(root.data>low){
            helper(root.left,low,high,res);
        }
        //do action
        if(root.data>=low && root.data <=high){
            res.add(root.data);
        }
        //right recursion call
        if(root.data<high){
            helper(root.right,low,high,res);
        }
    }

    //17. countNonLeafNodes:
    int countNonLeafNodes(Node root) {
         //base case
         if(root==null){
             return 0;
         }
        //do action on current node
         int cnt=1;
         if(root.left==null && root.right==null){
             return 0;
         }
        //recursion call
         int l=countNonLeafNodes(root.left);
         int r=countNonLeafNodes(root.right);
        //merge results
         return cnt+l+r;
    }
}
//18. Bfs (queue) level order traversal and dfs (recursion) post order,pre order,recursion handle all the subtree and each node handle left and right subtree and recursion in tree is trust your recursion call and dont go manually to child node because recursion handle all.






