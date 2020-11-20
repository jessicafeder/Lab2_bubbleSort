package com.company;

public class BinarySearch {
    Node root;

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
    /*
    Vilka fall för remove finns?
    1. Elementet finns i rootnoden och rootnoden har inga barn
    2. Elmentet finns i en lövnod
    3. Elementet finns en nod med ett barn
    3. Elementet finns i en nod med två barn
     */

    private int findMaxValue(Node tree){
        /*
              tree
    mindre->l      r<-större
         */
        if(tree.rightChild == null){
            return tree.key;
        }
        else{
            return findMaxValue(tree.rightChild);
        }
    }

    private int MaxValue(Node root) {
        int MaxValue = root.key;
        while (root.rightChild != null) {
            MaxValue = root.rightChild.key;
            root = root.leftChild;
        }
        return MaxValue;

    }

    public void remove(int key){
        root = remove_rec(root, key);
    }




    private Node remove_rec(Node tree, int key){
        /*

         */
        if (tree == null)
            return tree;
        if (key < tree.key)
            tree.leftChild = remove_rec(tree.leftChild, key);
        else if (key > tree.key)
            tree.rightChild = remove_rec(tree.rightChild, key);
        else {
            if (tree.leftChild == null)
                return tree.rightChild;
            else if (tree.rightChild == null)
                return tree.leftChild;

            tree.key = findMaxValue(tree.leftChild);
            tree.name = findNode(tree.key).name;
            tree.leftChild = remove_rec(tree.leftChild, tree.key);
        }
        return tree;
    }
    public void remove2( int x) {
        if (x == this.root.key && this.root.leftChild == null && this.root.rightChild == null) {
            this.root = null;
        } else {
            remove( x);
        }
    }

    public Node searchNodeBeforeUse(Node node, int x) {
        if (node == null) {
            return null;
        } else if (node.leftChild == null && node.rightChild == null) {
            return node;
        } else if (node.leftChild == null) {
            if (x == node.rightChild.key) {
                return node;
            } else {
                return searchNodeBeforeUse(node.rightChild, x);
            }
        } else if (node.rightChild == null) {
            if (x == node.leftChild.key) {
                return node;
            } else {
                return searchNodeBeforeUse(node.leftChild, x);
            }
        } else {
            if (x == node.leftChild.key || x == node.rightChild.key) {
                return node;
            } else {
                if (x > node.key) {
                    return searchNodeBeforeUse(node.rightChild, x);
                } else if (x < node.key) {
                    return searchNodeBeforeUse(node.leftChild, x);
                } else {
                    return node;
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

    public void ReverseInOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            ReverseInOrderTraverseTree(focusNode.rightChild);
            System.out.println(focusNode.key);
            ReverseInOrderTraverseTree(focusNode.leftChild);
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
        theTree.addNode(70,"Child 6");
        theTree.addNode(110,"Child 7");
        theTree.addNode(108,"Child 8");
        theTree.addNode(111,"Child 9");
        System.out.println(theTree.findNode(30)); // döpt get method till findNode
        System.out.println("------------------------------------------");
        //theTree.PreorderTraverseTree(theTree.root);
        theTree.inOrderTraverseTree(theTree.root);
        //theTree.PostorderTraverseTree(theTree.root);
        //System.out.println("Search for 30 ");
        //System.out.println(theTree.findNode(30));
        System.out.println("--------------------------------------------");
        theTree.remove(65);
        theTree.inOrderTraverseTree(theTree.root);



                    /*100
            50              110
        30      65        108   111
        25      55
                    58*/

    }
}

