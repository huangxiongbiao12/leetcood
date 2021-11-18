package com.hxb.sort;

import java.util.HashSet;
import java.util.Set;

public class QuickSort {

    /**
     * 快速快排序  选择一个数将小的放前面 大的放后面， 递归至一个元素时结束
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
        partition(arr, 0, arr.length - 1);
    }

    public static void partition(int[] arr, int left, int right) {
        if (left < 0 || right >= arr.length || left >= right) return;
        int temp = arr[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (temp >= arr[i]) {
                swap(arr, index++, i);
            }
        }
        arr[index] = temp;
        partition(arr, left, index - 1);
        partition(arr, index + 1, right);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
