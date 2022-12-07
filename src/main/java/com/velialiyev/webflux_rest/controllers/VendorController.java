package com.velialiyev.webflux_rest.controllers;

import com.velialiyev.webflux_rest.domain.Vendor;
import com.velialiyev.webflux_rest.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController("/api/v1/vendors")
public class VendorController {
    private final VendorRepository vendorRepository;

    @GetMapping
    Flux<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    @GetMapping("/{id}")
    Mono<Vendor> getVendorById(@PathVariable String id){
        return vendorRepository.findById(id);
    }
}
