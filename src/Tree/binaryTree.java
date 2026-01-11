package Tree;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class binaryTree {
 Node root;
 binaryTree(){
     root=null;
 }
 void preOrder(Node node) {
     if (node == null) return;
     System.out.println(node.data);
     preOrder(node.left);
     preOrder(node.right);
 }
 void levelOrder(Node node){
     if(node==null){
         return;
     }
     Queue<Node> q = new LinkedList<>();
     q.add(root);
     while(!q.isEmpty()){
         Node curr = q.poll();
         System.out.println(curr.data);
         if(curr.left!=null){
             q.add(curr.left);
         }
         if(curr.right!=null){
             q.add(curr.right);
         }
     }
 }
 int countNodes(Node root){
     int x,y;
     if(root!=null){
         x=countNodes(root.left);
         y=countNodes(root.right);
         return x+y+1;
     }
     return 0;
 }
 int pairNodes(Node root){
     int x,y;
     if(root!=null){
         x=pairNodes(root.left);
         y=pairNodes(root.right);
         if(root.left !=null && root.right!=null){
             return x+y+1;
         }else{
             return x+y;
         }
     }return 0;
 }
 int height(Node root){
     int x,y;
     if(root!=null){
         x = height(root.left);
         y = height(root.right);
         if(x>y){
             return x+1;
         }
         else{
             return y+1;
         }
     }
     return 0;
 }
 int leafNodes(Node root){
     int x,y;
     if(root!=null){
         x=leafNodes(root.left);
         y=leafNodes(root.right);
         if(root.left == root.right && root.right == null){
             return x+y+1;
         }
         else{
             return x+y;
         }
     }return 0;
 }
    public static void main(String[] args) {
        binaryTree tree = new binaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.print("Preorder: ");
        tree.preOrder(tree.root);
        System.out.println("LevelOrder");
        tree.levelOrder(tree.root);
        System.out.println("Number of Nodes in this tree is " + tree.countNodes(tree.root));
        System.out.println("The number of two pair nodes is "+ tree.pairNodes(tree.root));
        System.out.println("The height of tree is "+ tree.height(tree.root));
        System.out.println("The Leaf Nodes of tree is " + tree.leafNodes(tree.root));
 }
}
