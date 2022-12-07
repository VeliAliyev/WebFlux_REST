package com.velialiyev.webflux_rest.repository;

import com.velialiyev.webflux_rest.domain.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}
