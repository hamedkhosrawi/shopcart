package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.acme.entity.Cart;
import org.acme.entity.dto.CartDto;
import org.acme.repositories.CartRepository;
import org.acme.repositories.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j @ApplicationScoped @Transactional
public class CartService {

    @Inject
    CartRepository cartRepository;

    @Inject
    CustomerRepository customerRepository;

    public List<CartDto> findAll(){
        log.debug("request to get all Carts");
        return this.cartRepository.findAll()
                .stream()
                .map(CartService::mapToDto)
                .collect(Collectors.toList());
    }

    public static CartDto mapToDto(Cart cart){
        return null;
        /*return new CartDto(
                cart.getId(),
                CustomerService.mapToDto(cart.getCustomer()),
                cart.getStatus().name()
        );*/
    }
}
