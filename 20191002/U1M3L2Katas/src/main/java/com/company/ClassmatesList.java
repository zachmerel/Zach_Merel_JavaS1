package com.company;

import java.util.ArrayList;
import java.util.List;

public class ClassmatesList {

    private ArrayList<Classmate> classmates = new ArrayList<>();

    public void add(Classmate classmate){
        classmates.add(classmate);
    }

    public Classmate get(int classmateNumber){
       return classmates.get(classmateNumber);
    }

    public List<Classmate> getAll(){
        return classmates;
    }
}
