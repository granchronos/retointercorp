package com.intercorp.retail.maincustomer.expose.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Date fechaNacimiento;
    private Date fechaProbableMuerte;

    private Customer(Long id, String nombre, String apellido, Integer edad, Date fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
    }

    public static Customer of(CustomerEntity entity) {
        return new Customer(entity.getId(), entity.getName(), entity.getLastName(), entity.getAge(), entity.getBornDate());
    }

    private Customer(Long id, String nombre, String apellido, Integer edad, Date fechaNacimiento, Date fechaProbableMuerte) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaProbableMuerte = fechaProbableMuerte;
    }

    public static Customer with(CustomerEntity entity) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setFirstDayOfWeek((int) (Math.random() * 7 + 1));
        gregorianCalendar.add(Calendar.YEAR, 80 - entity.getAge());
        return new Customer(entity.getId(), entity.getName(), entity.getLastName(), entity.getAge(), entity.getBornDate(), gregorianCalendar.getTime());
    }
}
