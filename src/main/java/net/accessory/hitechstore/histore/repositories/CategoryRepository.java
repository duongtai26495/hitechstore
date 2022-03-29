package net.accessory.hitechstore.histore.repositories;

import net.accessory.hitechstore.histore.entities.Category;
import net.accessory.hitechstore.histore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c WHERE c.active = true")
    Category findAllCategory();
}
