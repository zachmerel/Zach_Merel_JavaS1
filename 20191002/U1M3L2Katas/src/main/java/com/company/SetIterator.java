package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {

    public void printSet(int a, int b, int c, int d, int e){
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(a);
        hashSet.add(b);
        hashSet.add(c);
        hashSet.add(d);
        hashSet.add(e);

        Iterator<Integer> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
