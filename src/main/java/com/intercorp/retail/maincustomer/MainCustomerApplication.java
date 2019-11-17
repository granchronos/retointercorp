package com.intercorp.retail.maincustomer;

import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import com.intercorp.retail.maincustomer.repository.entity.facade.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
public class MainCustomerApplication extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        new MainCustomerApplication().configure(new SpringApplicationBuilder(MainCustomerApplication.class)).run(args);
    }

    @Override
    public void run(String... args) {
        customerRepository.save(CustomerEntity.of("Antony", "Velasquez", 23, new GregorianCalendar(1996, Calendar.MARCH, 29).getTime()));
        customerRepository.save(CustomerEntity.of("Diana", "Centeno", 21, new GregorianCalendar(1997, Calendar.MARCH, 29).getTime()));
        customerRepository.save(CustomerEntity.of("Julio", "Ruiz", 61, new GregorianCalendar(1958, Calendar.MARCH, 29).getTime()));
    }

}
