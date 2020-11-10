package com.company;

import org.w3c.dom.Node;

public class BinarySearch {

    Node root;

    class Node{
        Node left;
        Node right;
        int key;

        Node(int key){
            this.key = key;
        }
    }
}
