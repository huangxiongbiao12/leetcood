package com.hxb.sort;

import java.util.Arrays;

// https://www.cnblogs.com/onepixel/articles/7674659.html
public class SortUtils {

    public static void main(String[] args) {
        int[] arr = new int[]{9, 2, 22, 11, 3, 7, 1, 3, 4, 21, 1};
//        selectSort(arr);
//        bubblingSort(arr);
//        insertSort(arr);
//        insertShellSort(arr);
//        mergeSort(arr);

        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }
    }


    /**
     * 选择排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[i] = arr[i] ^ arr[minIndex];
                arr[minIndex] = arr[i] ^ arr[minIndex];
                arr[i] = arr[i] ^ arr[minIndex];
            }
        }
    }

    /**
     * 冒泡
     *
     * @param arr
     */
    public static void bubblingSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }
    }

    /**
     * 插入排序   拿 第n个和 前一个比较比前面的小就交换 类似打牌放牌逻辑
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j - 1] > arr[j]) {
                arr[j] = arr[j] ^ arr[j - 1];
                arr[j - 1] = arr[j] ^ arr[j - 1];
                arr[j] = arr[j] ^ arr[j - 1];
                j--;
            }
//            for (int j = i + 1; j > 0; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    arr[j] = arr[j] ^ arr[j - 1];
//                    arr[j - 1] = arr[j] ^ arr[j - 1];
//                    arr[j] = arr[j] ^ arr[j - 1];
//                } else {
//                    break;
//                }
//            }
        }

    }

    /**
     * 希尔排序
     * <p>
     * 将数组分为n组，组的大小为gap，每次间隔gap的大小比较数据，不符和顺序就交换
     *
     * @param arr
     */
    public static void insertShellSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int length = arr.length;
        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int j = i;
                while (j >= gap && arr[j] < arr[j - gap]) {
                    arr[j] = arr[j] ^ arr[j - gap];
                    arr[j - gap] = arr[j] ^ arr[j - gap];
                    arr[j] = arr[j] ^ arr[j - gap];
                    j -= gap;
                }
//                for (int j = i; j >= gap; j -= gap) {
//                    if (arr[j] < arr[j - gap]) {
//                        arr[j] = arr[j] ^ arr[j - gap];
//                        arr[j - gap] = arr[j] ^ arr[j - gap];
//                        arr[j] = arr[j] ^ arr[j - gap];
//                    } else {
//                        break;
//                    }
//                }
            }
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return mergeArr(mergeSort(left), mergeSort(right));
    }


    public static int[] mergeArr(int[] a, int[] b) {
        int[] merge = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        int i = 0;
        while (ai < a.length || bi < b.length) {
            int min = 0;
            if (ai < a.length && bi < b.length) {
                if (a[ai] < b[bi]) {
                    min = a[ai];
                    ai++;
                } else {
                    min = b[bi];
                    bi++;
                }
            } else if (ai >= a.length) {
                min = b[bi];
                bi++;
            } else if (bi >= b.length) {
                min = a[ai];
                ai++;
            }
            merge[i] = min;
            i++;
        }
        return merge;
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = left;
            int index = pivot + 1;
            for (int i = index; i < arr.length; i++) {
                if (arr[pivot] > arr[i] && i != index) {
                    swap(arr, i, index);
                    index++;
                }
            }
            swap(arr, --index, pivot);
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, arr.length);
        }
    }

    /**
     * 交换下标
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
