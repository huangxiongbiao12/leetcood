package com.hxb.sort;

public class BucketSort {

    /**
     * 基数排序
     * <p>
     * 按位排序，先排低位 在排高位
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 3, 6, 5, 322, 6, 342, 2, 74};
        arr = sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] sort(int[] arr) {
        if (arr == null && arr.length < 2) return arr;
        // 最大位数
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            int m = 1;
            while (arr[i] / (int) Math.pow(10, m) > 0) {
                m++;
            }
            max = m > max ? m : max;
        }
        //每一位排序
        for (int i = 0; i < max; i++) {
            int[] buckets = new int[10];
            // 计算前缀和  buckets 代表 0-9 <=当前数字 有多少个
            for (int j = 0; j < arr.length; j++) {
                int retain = arr[j]/(int) Math.pow(10, i) % 10;
                for (int k = 0; k < buckets.length; k++) {
                    if (k >= retain) {
                        buckets[k] += 1;
                    }
                }
            }
            int[] temp = new int[arr.length];
            for (int k = arr.length - 1; k >= 0; k--) {
                int retain = arr[k]/(int) Math.pow(10, i) % 10;
                temp[buckets[retain] - 1] = arr[k];
                buckets[retain] -= 1;
            }
            arr = temp;
        }
        return arr;
    }


}
