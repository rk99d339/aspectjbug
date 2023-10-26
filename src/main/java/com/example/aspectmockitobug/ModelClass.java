package com.example.aspectmockitobug;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@MakeSecuredObject
public class ModelClass {

    private List<String> list = new ArrayList<>();

    Iterator<String> iterator;

    public ModelClass() {
        iterator = list.listIterator();
    }



    public void doWork() {
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
