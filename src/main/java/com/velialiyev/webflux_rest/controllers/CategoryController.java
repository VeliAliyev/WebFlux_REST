package com.velialiyev.webflux_rest.controllers;

import com.velialiyev.webflux_rest.domain.Category;
import com.velialiyev.webflux_rest.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController("/api/v1/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @GetMapping
    public Flux<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Category> getCategoryById(@PathVariable String id){
        return categoryRepository.findById(id);
    }
}
