package com.velialiyev.webflux_rest.bootstrap;

import com.velialiyev.webflux_rest.domain.Category;
import com.velialiyev.webflux_rest.domain.Vendor;
import com.velialiyev.webflux_rest.repository.CategoryRepository;
import com.velialiyev.webflux_rest.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = Category.builder().description("Fresh").build();
        Category cat2 = Category.builder().description("Nuts").build();
        Category cat3 = Category.builder().description("Dried").build();
        Category cat4 = Category.builder().description("Exotic").build();
        Category cat5 = Category.builder().description("Fruit").build();
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5));

        Vendor ven1 = Vendor.builder().firstName("Veli").lastName("Aliyev").build();
        Vendor ven2 = Vendor.builder().firstName("Ali").lastName("Veliyev").build();
        Vendor ven3 = Vendor.builder().firstName("Levi").lastName("Livayev").build();
        vendorRepository.saveAll(Arrays.asList(ven1, ven2, ven3));
    }
}
