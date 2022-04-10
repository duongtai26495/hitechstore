package net.accessory.hitechstore.histore.repositories;

import net.accessory.hitechstore.histore.entities.Brand;
import net.accessory.hitechstore.histore.entities.Product;
import net.accessory.hitechstore.histore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    Product getProductByName(@Param("name") String name);

    @Query("SELECT p FROM Product p Where p.id = :id")
    Product getProductById(@Param("id") Long id);
}
