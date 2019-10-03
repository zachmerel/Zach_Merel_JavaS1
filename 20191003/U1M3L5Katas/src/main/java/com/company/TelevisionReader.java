package com.company;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class TelevisionReader {

    public static void main(String[] args) {

        List<Television> tvList = new ArrayList<>();
        try {
            tvList = FileIO.getTelevisions("televisions.csv");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(tvList);


        // CODE GOES HERE
        List<Television> televisionList =
                tvList

                        .stream()
                        .collect(Collectors.toList());
        System.out.println("Television List: " + televisionList);

//        int screenSize = 60;
        System.out.println("=========Printing Big TVs=================");
        tvList.stream()
                .filter(tv -> tv.getScreenSize() > 60)
                .forEach(tv -> System.out.println(tv));

        System.out.println("=========Grouped TVs by brand=================");
        Map<String, List<Television>> groupedTVs =
                tvList
                        .stream()
                        .collect(Collectors.groupingBy(tv -> tv.getBrand()));
        Set<String> keys = groupedTVs.keySet();
        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("============Average Screen Size =====================");

        System.out.println("This is the average screen size: " + tvList.
                stream().
                mapToInt(Television::getScreenSize)
                .average()
                .getAsDouble());


        System.out.println("===============Largest Screen=======================");

        System.out.println("This is the largest screen size: " +tvList.
                stream()
                .mapToInt(Television::getScreenSize)
                .max()
                .getAsInt());
    }
}

