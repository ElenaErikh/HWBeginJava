package ru.geekbrains.hw.homework;

public class Lesson_2 {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        System.out.println("Создаем массив из миллиона элементов");
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.println(array[i]);
        }
    }
}
