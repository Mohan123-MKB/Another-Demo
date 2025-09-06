//1️⃣ Height of a Tree:
public int height(TreeNode root) {
    // 1. Base Case
    if (root == null) return 0;
    // 2. Do Action: nothing extra
    // 3. Recursive Case
    int left = height(root.left);
    int right = height(root.right);
    // 4. Merge
    return 1 + Math.max(left, right);
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
    if (root == null || root.left == null) return 0; // base
    return height(root.left); // reuse height problem
}
public int height(TreeNode node) {
    if (node == null) return 0;
    return 1 + Math.max(height(node.left), height(node.right));
}

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
}






