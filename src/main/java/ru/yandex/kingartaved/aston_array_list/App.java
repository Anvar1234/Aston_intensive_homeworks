package ru.yandex.kingartaved.aston_array_list;

import ru.yandex.kingartaved.aston_array_list.aston_list.impl.AstonArrayList;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("4");
        strings.add("5");

        AstonArrayList<String> stringAstonArrayList = new AstonArrayList<>(strings);
        System.out.println("stringAstonArrayList : \n" + stringAstonArrayList);
        System.out.println("size : \n" + stringAstonArrayList.size() + "\n");

        AstonArrayList<String> stringAstonArrayList2 = new AstonArrayList<>();

        stringAstonArrayList2.add(0, "1");
        stringAstonArrayList2.add(1, "2");
        stringAstonArrayList2.add(1, "8");
        stringAstonArrayList2.add(2, "3");
        stringAstonArrayList2.add(3, "4");
        System.out.println("stringAstonArrayList2 : ");
        System.out.println("after adds : \n" + stringAstonArrayList2);
        System.out.println("size : \n" + stringAstonArrayList2.size() + "\n");

        stringAstonArrayList2.addAll(strings);
        System.out.println("after addAll : \n" + stringAstonArrayList2);
        System.out.println("size : \n" + stringAstonArrayList2.size() + "\n");

        System.out.println("after get[3] : " + stringAstonArrayList2.get(3) + "\n");

        System.out.println("isEmpty : \n" + stringAstonArrayList2.isEmpty() + "\n");

        stringAstonArrayList2.sort(String::compareTo);
        System.out.println("after sort : ");
        System.out.println(stringAstonArrayList2 + "\n");

        stringAstonArrayList2.remove(1);
        System.out.println("after remove[1] : \n" + stringAstonArrayList2);
        System.out.println("size : \n" + stringAstonArrayList2.size() + "\n");

        stringAstonArrayList2.remove("5");
        System.out.println("after remove \"5\" : \n" + stringAstonArrayList2);
        System.out.println("size : \n" + stringAstonArrayList2.size() + "\n");

        stringAstonArrayList2.clear();
        System.out.println("after clear : \n" + stringAstonArrayList2);
        System.out.println("size : \n" + stringAstonArrayList2.size() + "\n");
    }
}
