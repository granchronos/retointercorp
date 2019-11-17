package com.intercorp.retail.maincustomer.repository.entity;

import com.intercorp.retail.maincustomer.exception.CustomerException;
import com.intercorp.retail.maincustomer.expose.model.Customer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

import static com.intercorp.retail.maincustomer.business.util.CustomerExceptionUtil.isNotnull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastName;

    private Integer age;

    private Date bornDate;

    private CustomerEntity(String name, String lastName, Integer age, Date bornDate) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.bornDate = bornDate;
    }

    public static CustomerEntity of(String name, String lastName, Integer age, Date bornDate) {
        return new CustomerEntity(name, lastName, age, bornDate);
    }

    public static CustomerEntity of(Customer customer) throws CustomerException {
        isNotnull(customer.getNombre(), "nombre");
        isNotnull(customer.getApellido(), "apellido");
        isNotnull(customer.getEdad(), "edad");
        isNotnull(customer.getFechaNacimiento(), "fechaNacimiento");
        return new CustomerEntity(customer.getNombre(), customer.getApellido(), customer.getEdad(), customer.getFechaNacimiento());
    }

}
