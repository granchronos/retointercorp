package com.intercorp.retail.maincustomer;

import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import com.intercorp.retail.maincustomer.repository.entity.facade.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SpringBootApplication
@AllArgsConstructor
public class MainCustomerApplication implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(MainCustomerApplication.class, args);
    }

    @Override
    public void run(String... args) {

        customerRepository.save(CustomerEntity.of("Antony", "Velasquez", 23, new GregorianCalendar(1996, Calendar.MARCH, 29).getTime()));
        customerRepository.save(CustomerEntity.of("Diana", "Centeno", 21, new GregorianCalendar(1997, Calendar.MARCH, 29).getTime()));
        customerRepository.save(CustomerEntity.of("Julio", "Ruiz", 61, new GregorianCalendar(1958, Calendar.MARCH, 29).getTime()));


        System.out.println("\nfindAll()");
        customerRepository.findAll().forEach(System.out::println);

        System.out.println("\nfindById(1L)");
        customerRepository.findById(1L).ifPresent(System.out::println);

    }

}
