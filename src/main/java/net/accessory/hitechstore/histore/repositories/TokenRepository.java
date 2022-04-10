package net.accessory.hitechstore.histore.repositories;

import net.accessory.hitechstore.histore.entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    @Query("SELECT t FROM Token t WHERE t.old_token = :old_token")
    boolean isExist(String old_token);

}
