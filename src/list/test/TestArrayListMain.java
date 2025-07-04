package list.test;

import java.util.ArrayList;

public class TestArrayListMain {
    public static void main(String[] args) {
        TestArrayList<String> list = new TestArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("왕우민");
        System.out.println("list = " + list);

        int i = list.indexOf("1");
        System.out.println("i = " + i);
    }
}
