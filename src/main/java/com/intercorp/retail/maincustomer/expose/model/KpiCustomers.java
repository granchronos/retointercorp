package com.intercorp.retail.maincustomer.expose.model;

import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class KpiCustomers {

    private Double average;
    private Double standardDeviation;

    public static KpiCustomers of(Double average, Double standardDeviation) {
        BigDecimal bd = BigDecimal.valueOf(standardDeviation);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return new KpiCustomers(average, bd.doubleValue());
    }

}
