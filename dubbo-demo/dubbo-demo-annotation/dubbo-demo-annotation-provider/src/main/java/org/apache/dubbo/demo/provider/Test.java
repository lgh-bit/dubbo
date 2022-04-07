package org.apache.dubbo.demo.provider;

/**
 * @author: liuguohong
 * @date: 4/1/22 8:50 PM
 */
public class Test {
    public static void main(String[] args) {
        int[] array = {5,2,3,1};
        sort(array);
        System.out.println();
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void sort(int [] array) {
        quickSort(array, 0, array.length -1);
    }

    private static void quickSort(int [] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition2(array, left, right);
        quickSort(array, left, p-1);
        quickSort(array, p +1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = i;
        int privot = array[right];
        while (j < right) {
            if (array[j] <= privot) {
                swap(array, i, j);
                i++;
            }
            j++;
        }
        swap(array, i, right);
        return i;
    }

    private static int partition2(int[] array, int left, int right) {
        int i = left,j = right;
        int pivot = array[left];
        while(i < j) {
            // 找第一个比
            while (i < j && array[j] >= pivot) {
                j--;
            }
            if (i  < j) {
                swap(array, i, j);
            }
            while(i < j && array[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        return i;

    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
