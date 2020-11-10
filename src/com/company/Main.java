package com.company;

public class Main {

    public static void main(String[] args) {
        BubbleSort ob = new BubbleSort();
        PrintArray pa = new PrintArray();
        int arr[] = {3,6, 65,11, 5,1};
        ob.bubbleSort(arr);
        System.out.println("Sorted array");
        pa.printArray(arr);
    }
}
