package com.company;

public class BinaryTree {
    Node root;

    public void addNode(int key, String name) {


        Node newNode = new Node(key, name);
        if (root == null) {
            root = newNode;

        } else {
            Node focusNode = root;

            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.key) {
                    focusNode = focusNode.leftchild;
                    if (focusNode == null) {
                        parent.leftchild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightchild;
                    if (focusNode == null) {
                        parent.rightchild = newNode;
                        return;
                    }
                }
            }

        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftchild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightchild);

        }

    }

    public void PreorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            PreorderTraverseTree(focusNode.leftchild);
            PreorderTraverseTree(focusNode.rightchild);
        }
    }

    public void PostorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            PostorderTraverseTree(focusNode.leftchild);
            PostorderTraverseTree(focusNode.rightchild);
            System.out.println(focusNode);
        }
    }

    class Node {
        int key;
        String name;

        Node leftchild;
        Node rightchild;


        Node(int key, String name) {

            this.key = key;
            this.name = name;
        }

        public String toString() {
            return name + " has a key " + key;
        }

    }

    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftchild;
            } else {
                focusNode = focusNode.rightchild;
            }
            if (focusNode == null)
                return null;

        } return focusNode;
    }



        public static void main(String [] Args){
            BinaryTree theTree = new BinaryTree();
            theTree.addNode(50,"Boss");
            theTree.addNode(25,"Vice Pres");
            theTree.addNode(15,"office manager");
            theTree.addNode(30,"Secratary");
            theTree.addNode(75,"sales manager");
            theTree.addNode(85,"salesman 1");

            theTree.PreorderTraverseTree(theTree.root);
            System.out.println("Search for 30 ");
            System.out.println(theTree.findNode(30));



        }
    }