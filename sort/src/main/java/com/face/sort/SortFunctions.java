package com.face.sort;

import java.util.Arrays;

/**
 * Create by lifan.
 * Date: 2019/4/30.
 * Time: 10:55.
 */
public class SortFunctions {


    public int[] quickSort(int[] arr, int left, int right) {
        int len = arr.length, partitionIndex;

        if (left < right) {
            partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = left, index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        SortFunctions s = new SortFunctions();
        int[] arr = new int[]{12, 20, 5, 16, 15, 1, 30, 45, 23, 9};
        System.out.println(Arrays.toString(arr));
        arr = s.quickSort(arr, 0, 9);
    }
}
