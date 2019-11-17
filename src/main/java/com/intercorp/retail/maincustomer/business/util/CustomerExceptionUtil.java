package com.intercorp.retail.maincustomer.business.util;

import com.intercorp.retail.maincustomer.exception.CustomerException;

import java.util.Date;

public class CustomerExceptionUtil {

    public static void isNotnull(String value, String name) throws CustomerException {
        if (value == null) {
            throw new CustomerException("value is null in " + name);
        }
    }

    public static void isNotnull(Integer value, String name) throws CustomerException {
        if (value == null) {
            throw new CustomerException("value is null in " + name);
        }
    }

    public static void isNotnull(Date value, String name) throws CustomerException {
        if (value == null) {
            throw new CustomerException("value is null in " + name);
        }
    }

}
