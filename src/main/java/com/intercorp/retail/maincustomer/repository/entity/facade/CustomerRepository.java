package com.intercorp.retail.maincustomer.repository.entity.facade;

import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
