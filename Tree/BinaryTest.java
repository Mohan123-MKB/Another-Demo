package Tree;
import java.util.*;
class BinaryTree{
    BinaryTree(){

    }

private static class Node{
    int val;
    Node left;
    Node right;
    Node(int val){
        this.val=val;

    }
}

private Node root;
//insert elements
public void populate(Scanner sc){
System.out.println("Enter the root node");
int val=sc.nextInt();
root=new Node(val);
populate(sc,root);
}

//helper function build tree
private void populate(Scanner sc,Node node){
    System.out.println("Do you want to enter left of" + node.val);
    boolean left=sc.nextBoolean();
    if(left){
        System.out.println("Enter the value of the left of" + node.val);
        int val=sc.nextInt();
        node.left=new Node(val);
        populate(sc,node.left);
    }
    System.out.println("Do you want to enter right of"+node.val);
    boolean right=sc.nextBoolean();
    if(right){
        System.out.println("Enter the value of the right of"+node.val);
        int val=sc.nextInt();
        node.right=new Node(val);
        populate(sc,node.right);
    }
}
//display result
public void display(){
    display(this.root,"");
}
private void display(Node node,String indent){
    if(node==null){
        return;
    }
    System.out.println(indent+node.val);
    display(node.left,indent+"\t");
    display(node.right,indent+"\t");
}
}

public class BinaryTest {
    public static void main(String ar[]){
        Scanner sc=new Scanner(System.in);
        BinaryTree tree=new BinaryTree();
        tree.populate(sc);
        tree.display();
    }
    
}
