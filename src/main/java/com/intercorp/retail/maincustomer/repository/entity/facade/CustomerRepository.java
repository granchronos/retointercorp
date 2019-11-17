package com.intercorp.retail.maincustomer.repository.entity.facade;

import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
