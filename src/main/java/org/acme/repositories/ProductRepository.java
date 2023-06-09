package org.acme.repositories;

import org.acme.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    List<Product> findByCategoryId(Long categoryId);

    Long countAllByCategoryId(Long categoryId);
    @Query("select p from Product p JOIN p.review r WHERE r.id = ?1")
    Product findProductByReviewId(Long reviewId);

    void deleteAllByCategoryId(Long id);
    List<Product> findAllByCategoryId(Long id);


}
