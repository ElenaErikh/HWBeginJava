package ru.geekbrains.hw.homework;

class MyArr {
    private int[] array;
    private int size;

    public MyArr(int size) {
        this.size = 1000000;
        this.array = new int[size];
    }

    public void generate() {
        for (int i = 0; i < this.size; i++) {
            array[i] = i + 1;
            System.out.println(this.array[i]);
        }
    }

    public boolean binaryFind(int value){
        int low = 0;
        int high = this.size - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (value == this.array[mid]) {
                return true;
            } else {
                if (value < this.array[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    public boolean find(int value) {
        int i;
        for (i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.array[i]);
        }
    }

    public void delete(int value){
        int i = 0;
        for(i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                break;
            }
        }

        for (int j = i; j < this.size - 1; j++){
            this.array[j] = this.array[j + 1];
        }
        this.size--;
    }

    public void insert(int value){
        int i;
        for(i = 0; i < this.size; i++) {
            if (this.array[i]>value) {
                break;
            }
        }
        for (int j = this.size; j > i; j--){
            this.array[j] = this.array[j-1];
        }
        this.array[i] = value;
        this.size++;
    }
}

public class Lesson_2_part1 {
    public static void main(String[] args) {
        MyArr arr = new MyArr(1000000);
        int search = 111111;

        System.out.println("Создаем массив");
        arr.generate();
        System.out.println("Удаляем элемент");
        arr.delete(999999);
        arr.display();
        System.out.println("Добавляем элемент");
        arr.insert(1000001);
        arr.display();
        System.out.println("Ищем элемент. Линейный поиск");
        System.out.println(arr.find(search));
        System.out.println("Ищем элемент. Двоичный поиск");
        System.out.println(arr.binaryFind(search));
    }
}
