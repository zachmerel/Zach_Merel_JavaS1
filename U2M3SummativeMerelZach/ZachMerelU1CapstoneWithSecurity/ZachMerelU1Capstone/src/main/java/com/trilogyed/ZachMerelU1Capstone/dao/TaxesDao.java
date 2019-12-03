package com.trilogyed.ZachMerelU1Capstone.dao;

import com.trilogyed.ZachMerelU1Capstone.model.StateTaxRate;

import java.math.BigDecimal;

public interface TaxesDao {

    StateTaxRate getTaxRate (String state);
}
