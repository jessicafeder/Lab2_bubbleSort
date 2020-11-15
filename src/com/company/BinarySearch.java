package com.company;

public class BinarySearch {
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
                    focusNode = focusNode.leftChild;
                    if (focusNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    focusNode = focusNode.rightChild;
                    if (focusNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }

        }
    }

    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.leftChild);
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.rightChild);

        }

    }

    public void PreorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            PreorderTraverseTree(focusNode.leftChild);
            PreorderTraverseTree(focusNode.rightChild);
        }
    }

    public void PostorderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            PostorderTraverseTree(focusNode.leftChild);
            PostorderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode);
        }
    }

    class Node {
        int key;
        String name;

        Node leftChild;
        Node rightChild;


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
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null)
                return null;

        } return focusNode;
    }



    public static void main(String [] Args){
        BinarySearch theTree = new BinarySearch();
        theTree.addNode(100,"Boss");
        theTree.addNode(50,"Child 1");
        theTree.addNode(65,"Child 2");
        theTree.addNode(55,"Child 3");
        theTree.addNode(58,"Child 4");
        theTree.addNode(30,"Child 5");
        theTree.addNode(25,"Child 6");
        theTree.addNode(110,"Child 7");
        theTree.addNode(108,"Child 8");
        theTree.addNode(111,"Child 9");

        //theTree.PreorderTraverseTree(theTree.root);
        //theTree.inOrderTraverseTree(theTree.root);
        theTree.PostorderTraverseTree(theTree.root);
        System.out.println("Search for 30 ");
        System.out.println(theTree.findNode(30));


                    /*100
            50              110
        30      65        108   111
        25      55
                    58*/

    }
}

