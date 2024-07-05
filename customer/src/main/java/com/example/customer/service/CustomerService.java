package com.example.customer.service;

import com.example.clients.fraud.FraudCheckResponse;
import com.example.clients.fraud.FraudClient;
import com.example.clients.notification.NotificationClient;
import com.example.clients.notification.NotificationDTO;
import com.example.customer.dto.CustomerDTO;
import com.example.customer.entity.Customer;
import com.example.customer.mappers.CustomerMapper;
import com.example.customer.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {


    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public HttpEntity<?> register(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customerRepository.save(customer);

        FraudCheckResponse fraudCheckResponse = fraudClient.checkFraudster(customer.getId());


        if (fraudCheckResponse.getIsFraudster()) {
            throw new RuntimeException("real fraud :)");

        }
        notificationClient.save(new NotificationDTO(
                customer.getId(), " Everything is under my control"
        ));

        return ResponseEntity.status(201).body(customer);
    }
}
