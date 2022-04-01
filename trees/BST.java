package com.trees;

class BST {
    private Node root;
    //Basic Node definition. Each Node contains a Value, a left child, and a right child
    class Node {
        int val;
        Node left, right;

        public Node(int value) {
            val = value;
            left =null;
            right = null;
        }
    }


    public BST(int rootValue) {
        root = new Node(rootValue);
    }

    //insert Value into the appropriate spot in the tree
    private Node insert(Node root,int value) {


        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.val)
            root.left = insert(root.left, value);
        else if (value > root.val)
            root.right = insert(root.right, value);

        return root;
    }


    //finish code to print all values with an inorder traversal
    void inorderTraversal(Node root) {
        //base case
        if (root==null) {
            return;
        }
        inorderTraversal(root.left);//visit left node
        System.out.print(root.val+" ");//print value
        inorderTraversal(root.right);//visit left node
    }

    public void preorderTraversal(Node root){
        if(root==null) return;//base case
        System.out.print(root.val+" ");//root first
        preorderTraversal(root.left);//then visit left node
        preorderTraversal(root.right);//then finally right node
    }

    public void postorderTraversal(Node root){
        if(root==null) return;//base case
        postorderTraversal(root.left);//visit left first
        postorderTraversal(root.right);//then go to right
        System.out.print(root.val+" ");//then finally print root
    }

    private boolean search(int n){
        return search2(root,n);
    }
    //main search algorithm
    private boolean search2(Node root,int n){
        //base cases
        if(root==null) return false;
        if(root.val==n) return true;
        //if value is lower then go to left of tree
        if(n<root.val)
            return search2(root.left,n);
        //if value is higher then go to right of tree
        if(n> root.val)
            return search2(root.right,n);
        return false;
    }

    public static void main(String[] args) {
        //create tree with a root of 5
        BST tree = new BST(5);

        tree.insert(tree.root,2);
        tree.insert(tree.root,7);
        tree.insert(tree.root,10);
        tree.insert(tree.root,4);
        tree.insert(tree.root,1);

        //traversals
        tree.inorderTraversal(tree.root);
        System.out.println();
        tree.preorderTraversal(tree.root);
        System.out.println();
        tree.postorderTraversal(tree.root);
        System.out.println();
        //search
        if(tree.search(3))
            System.out.println("true");
        else
            System.out.println("False");
    }
}
