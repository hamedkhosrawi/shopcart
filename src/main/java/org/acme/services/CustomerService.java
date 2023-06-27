package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.acme.repositories.CustomerRepository;

@Slf4j @ApplicationScoped @Transactional
public class CustomerService {
    @Inject
    CustomerRepository customerRepository;
}
