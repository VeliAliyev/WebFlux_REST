package com.velialiyev.webflux_rest.controllers;

import com.velialiyev.webflux_rest.domain.Category;
import com.velialiyev.webflux_rest.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public Mono<Void> createCategory(@RequestBody Publisher<Category> categoryPublisher){
        return categoryRepository.saveAll(categoryPublisher).then();
    }

    @PutMapping("/{id}")
    public Mono<Category> updateCategory(@PathVariable String id, @RequestBody Category category){
        category.setId(id);
        return categoryRepository.save(category);
    }

    @PatchMapping("/{id}")
    public Mono<Category> patchCategory(@PathVariable String id, @RequestBody Category category){
        Category foundCategory = categoryRepository.findById(id).block();

        if(!foundCategory.getDescription().equals(category.getDescription())){
            foundCategory.setDescription(category.getDescription());
            return categoryRepository.save(foundCategory);
        }
        return Mono.just(foundCategory);
    }
}
