package com.intercorp.retail.maincustomer.business;

import com.intercorp.retail.maincustomer.exception.CustomerException;
import com.intercorp.retail.maincustomer.expose.model.Customer;
import com.intercorp.retail.maincustomer.expose.model.KpiCustomers;
import com.intercorp.retail.maincustomer.repository.entity.CustomerEntity;
import com.intercorp.retail.maincustomer.repository.entity.facade.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(Customer customer) throws CustomerException {
        CustomerEntity customerEntity = CustomerEntity.of(customer);
        CustomerEntity newCustomer = customerRepository.save(customerEntity);
        return Customer.of(newCustomer);
    }

    public KpiCustomers getKpiCustomers() {
        List<CustomerEntity> customers = customerRepository.findAll();
        DoubleSummaryStatistics stats = customers.stream()
                .mapToDouble(CustomerEntity::getAge)
                .summaryStatistics();

        AtomicReference<Double> sum = new AtomicReference<>((double) 0);

        for (CustomerEntity customer : customers) {
            sum.accumulateAndGet(Math.pow(customer.getAge().doubleValue() - stats.getAverage(), 2), Double::sum);
        }

        return KpiCustomers.of(stats.getAverage(), Math.sqrt(sum.get() / stats.getCount()));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository
                .findAll()
                .stream()
                .map(Customer::of)
                .collect(Collectors.toList());
    }

}
