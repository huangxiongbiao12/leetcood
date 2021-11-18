package com.hxb.sort;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 3, 6, 5, 322, 6, 342, 2, 74};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sort(int[] arr) {
        if (arr == null && arr.length < 2) return;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i;
            for (int j = i; j > 0; j--) {
                if (temp < arr[j-1]) {
                    arr[j] = arr[j-1];
                    index--;
                }
            }
            arr[index] = temp;
        }
    }



}
