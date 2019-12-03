package com.trilogyed.ZachMerelU1Capstone.dao;


import com.trilogyed.ZachMerelU1Capstone.model.ProcessingFee;

import java.math.BigDecimal;

public interface ProcessingFeeDao {

    ProcessingFee getProcessingFee (String product_type);
}
