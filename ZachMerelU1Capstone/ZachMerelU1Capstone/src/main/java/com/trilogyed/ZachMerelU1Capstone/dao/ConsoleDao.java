package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.Console;

import java.util.List;

public interface ConsoleDao {

    Console addConsole(Console console);

    Console getConsole(int id);

    List<Console> getAllConsoles();

    List<Console> getAllConsolesByManufacturer( String manufacturer);

    void updateConsole(Console console);

    void deleteConsole(int id);
}
