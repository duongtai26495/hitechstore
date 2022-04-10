package net.accessory.hitechstore.histore.repositories;

import net.accessory.hitechstore.histore.entities.Brand;
import net.accessory.hitechstore.histore.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    @Query("SELECT b FROM Brand b WHERE b.name = :name")
    Brand getBrandByName(@Param("name") String name);
}
