package Tree;
import java.util.*;
class BST{
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    private Node root;
    //insert a node using recursion
    public void insert(int val){
    root=insertRec(root,val);
    }
    private Node insertRec(Node node,int val){
        if(node==null){
            return new Node(val);
        }
        if(val<node.val){
            node.left=insertRec(node.left,val);
        }
        else if(val>node.val){
            node.right=insertRec(node.right,val);
        }
        return node;
    }

    // Inorder traversal (sorted output)
    public void inorder() {
        System.out.print("Inorder: ");
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node node){
        if(node==null){
            return;
        }
        inorderRec(node.left);
        System.out.print(node.val + " ");
        inorderRec(node.right);
    }

    // Search for a value in BST
    public boolean search(int val) {
        return searchRec(root, val);
    }

    private boolean searchRec(Node node, int val) {
        if (node == null){ 
            return false;
        }
        if (val == node.val) {
            return true;
        }
        if(val<node.val){ //value is less than cur_Node then go to left
            return searchRec(node.left, val);
        }
        else{ //value is greater than cur_Node then go to right
            return searchRec(node.right, val);
        }
    }
}
public class BinarySearchTest {
    public static void main(String ar[]){
        BST tree=new BST();
        int[] values={50,30,70,20,40,60,80};
        for(int val:values){
            tree.insert(val); //it call inside insertRec()method
        }
        tree.inorder(); //sorted output get and it call inside inorderRec()method
        System.out.println(tree.search(80)); //it call inside searchRec()method
    }  
}

