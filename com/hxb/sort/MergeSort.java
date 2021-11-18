package com.hxb.sort;

public class MergeSort {

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
        if (left == right) return;
        int mid = left + (right - left) / 2;
        partition(arr, left, mid);
        partition(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }


    public static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int lIndex = left;
        int rIndex = mid + 1;
        int i = 0;
        while (lIndex <= mid && rIndex <= right) {
            help[i++] = arr[lIndex] > arr[rIndex] ? arr[rIndex++] : arr[lIndex++];
        }
        for (int j = i; j < help.length; j++) {
            help[j] = lIndex <= mid ? arr[lIndex++] : arr[rIndex++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j + left] = help[j];
        }
    }


}
