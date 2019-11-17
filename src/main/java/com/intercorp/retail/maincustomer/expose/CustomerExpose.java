package com.intercorp.retail.maincustomer.expose;

import com.intercorp.retail.maincustomer.business.CustomerService;
import com.intercorp.retail.maincustomer.exception.CustomerException;
import com.intercorp.retail.maincustomer.expose.model.Customer;
import com.intercorp.retail.maincustomer.expose.model.KpiCustomers;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerExpose {

    private final CustomerService customerService;

    @PostMapping("creacliente")
    private ResponseEntity<Customer> create(@RequestBody Customer customer) throws CustomerException {
        Customer response = customerService.saveCustomer(customer);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("kpideclientes")
    private ResponseEntity<KpiCustomers> obtainData() {
        return ResponseEntity.ok(customerService.getKpiCustomers());
    }

    @GetMapping("listclientes")
    public ResponseEntity<List<Customer>> obtainAll() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

}
