package com.hxb.sort;

public class HeapSort {

    /**
     * 堆排序  完全二叉树  数组序号和树的父子节点关系
     * 序号i 节点  父节点 （i-1）/2  , 左节点 2*i+1 右节点 2*i+2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 3, 6, 5, 322, 6, 342, 2, 74};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {
        if (arr == null && arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length - 1;
        while (heapSize > 0) {
            swap(arr, 0, heapSize--);
            heapDown(arr, 0, heapSize);
        }
    }

    public static void heapInsert(int[] arr, int i) {
        int parent = (i - 1) / 2;
        while (parent >= 0 && arr[i] > arr[parent]) {
            swap(arr, i, parent);
            heapInsert(arr, parent);
        }
    }

    public static void heapDown(int[] arr, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        while ((left <= heapSize && arr[i] < arr[left]) || (right <= heapSize && arr[i] < arr[right])) {
            int index = right <= heapSize ? (arr[left] > arr[right] ? left : right) : left;
            swap(arr, i, index);
            heapDown(arr, index, heapSize);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
