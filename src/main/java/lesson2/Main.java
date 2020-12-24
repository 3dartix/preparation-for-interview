package lesson2;

import lombok.extern.java.Log;

@Log
public class Main {
    public static void main(String[] args) {
        MyArray<String> array = new MyArray<String>();
        array.add("вцв");
        array.add("3фвцфаф");
        array.add("345454");
        array.add("454646");
        System.out.println(array);
        array.remove("вцв");
        System.out.println(array);
        array.add("454646");
        System.out.println(array);

        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        myLinkedList.add("фцафцацфа");
        myLinkedList.add("12414124");
        myLinkedList.add("34а34а34аа");
        System.out.println(myLinkedList.size());
        myLinkedList.addFirst("####");
        System.out.println(myLinkedList);
    }
}
