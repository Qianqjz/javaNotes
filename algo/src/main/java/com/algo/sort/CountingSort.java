package com.algo.sort;


import com.algo.utils.Untils;

public class CountingSort {
    public int[] sort(int[] arr) throws Exception {

        int maxValue = getMaxValue(arr);

        return countingSort(arr, maxValue);
    }

    private int[] countingSort(int[] arr, int maxValue) {
        int bucketLen = maxValue + 1;
        int[] bucket = new int[bucketLen];

        for (int value : arr) {
            bucket[value]++;
        }

        int sortedIndex = 0;
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) throws Exception {
        CountingSort countingSort=new CountingSort();
        countingSort.sort(Untils.arr);
        Untils.printArr(Untils.arr);
    }
}
