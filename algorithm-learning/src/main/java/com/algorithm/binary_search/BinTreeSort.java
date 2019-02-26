package com.algorithm.binary_search;

/**
 * @Author: wangxc
 * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 * @wxid: BMHJQS
 */
public class BinTreeSort {
    public static void main(String[] args) {
        int[] arr = {10, 2, 300, 41, 15, 6};
        for (int a : arr) {
            System.out.print(a + "\t");
        }
        binaryInsertSort(arr);
        System.out.println();
        for (int a : arr) {
            System.out.print(a + "\t");
        }
    }

    public static void binaryInsertSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (a[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i - 1; j >= low; j--) {
                a[j + 1] = a[j];
            }
            a[low] = temp;
        }
    }
}
