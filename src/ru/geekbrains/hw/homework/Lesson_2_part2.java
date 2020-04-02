package ru.geekbrains.hw.homework;

import java.util.Arrays;

public class Lesson_2_part2 {
    public static void main(String[] args) {
        int len = 5;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 50);
        }
        int low = 0;
        int high = arr.length - 1;

        System.out.println("Массив случайных чисел\n" + Arrays.toString(arr));
        System.out.println("Пузырьковая сортировка ");
        sortBubble(arr);
        System.out.println("Сортировка выбором");
        sortSelect(arr);
        System.out.println("Сортировка вставками");
        sortInsert(arr);
        System.out.println("Быстрая сортировка");
        quickSort(arr, low, high);
    }

    private static void change(int[] arrToChange,int a, int b){
        int tmp = arrToChange[a];
        arrToChange[a] = arrToChange[b];
        arrToChange[b] = tmp;
    }

    public static void sortBubble(int[] arrayToSort){
        int[] array1 = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int out, in;

        for (out = array1.length - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (array1[in] > array1[in + 1]) {
                    change(array1, in, in + 1);
                }
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array1));
    }

    public static void sortSelect(int[] arrayToSort){
        int[] array2 = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int out, in, mark;

        for(out = 0; out < array2.length; out++){
            mark = out;
            for(in = out + 1; in < array2.length; in++){
                if (array2[in] < array2[mark]){
                    mark = in;
                }
            }
            change(array2, out, mark);
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array2));
    }

    public static void sortInsert(int[] arrayToSort){
        int[] array3 = Arrays.copyOf(arrayToSort, arrayToSort.length);
        long start = System.nanoTime();
        int in, out;

        for(out = 1; out < array3.length; out++){
            int temp = array3[out];
            in = out;
            while(in > 0 && array3[in - 1] >= temp){
                array3[in] = array3[in - 1];
                --in;
            }
            array3[in] = temp;
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array3));
    }

    public static void quickSortImpl(int[] array, int low, int high){

        if (array.length == 0)
            return;
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        int base = array[middle];

        int i = low, j = high;
        while (i <= j) {
            while (array[i] < base) {
                i++;
            }
            while (array[j] > base) {
                j--;
            }
            if (i <= j) {
                change(array, i, j);
                i++;
                j--;
            }
        }
        if (low < j)
            quickSortImpl(array, low, j);
        if (high > i)
            quickSortImpl(array, i, high);
    }

    private static void quickSort(int[] array, int low, int high) {
        long start = System.nanoTime();
        quickSortImpl(array, low, high);
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(array));
    }
}


