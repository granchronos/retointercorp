package com.intercorp.retail.maincustomer.expose.model;

import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Customer {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Date fechaNacimiento;

    public static Customer of(CustomerEntity entity) {
        return new Customer(entity.getId(), entity.getName(), entity.getLastName(), entity.getAge(), entity.getBornDate());
    }

}
