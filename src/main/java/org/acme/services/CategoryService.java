package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.acme.entity.Category;
import org.acme.entity.dto.CategoryDto;
import org.acme.entity.dto.ProductDto;
import org.acme.repositories.CategoryRepository;
import org.acme.repositories.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ApplicationScoped
@Transactional
public class CategoryService {

    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ProductRepository productRepository;

    public static CategoryDto mapToDto(Category category, Long productCount){
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                productCount);
    }

    public List<CategoryDto> findAll(){
        log.debug("Request to get all categories");
        return this.categoryRepository.findAll()
                .stream()
                .map(category -> mapToDto(category,
                        productRepository.countAllByCategoryId(category.getId())))
                .collect(Collectors.toList());
    }

    public CategoryDto findById(Long id){
        log.debug("Request to get Category : {}", id);
        return this.categoryRepository.findById(id).map(
                category -> mapToDto(category, productRepository.countAllByCategoryId(category.getId()))

        ).orElse(null);
    }

    public CategoryDto create(CategoryDto categoryDto){
        log.debug("Request to create Category : {}", categoryDto);
        return mapToDto(this.categoryRepository
                .save(new Category(categoryDto.getName(),categoryDto.getDescription())),0L);
    }

    public void delete(){}

    public List<ProductDto> findProductByCategoryId(Long id){
        return null;
    }
}
