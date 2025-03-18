package ru.yandex.kingartaved.aston_sort;

import ru.yandex.kingartaved.aston_sort.merge_sort.MergeSort;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(12);
        integers.add(10);
        integers.add(2);
        integers.add(1);
        integers.add(9);
        integers.add(1);
        integers.add(3);
        integers.add(0);
        integers.add(8);
        System.out.println("before mergeSort : " + integers);

        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.mergeSort(integers);
        System.out.println("after mergeSort : " + integers);
    }
}
