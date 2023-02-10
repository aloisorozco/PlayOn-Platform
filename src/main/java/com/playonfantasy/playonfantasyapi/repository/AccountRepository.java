package com.playonfantasy.playonfantasyapi.repository;

import com.playonfantasy.playonfantasyapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account findByUsername(String username);

    public Account findByEmailAndPassword(String email, String password);

    @Query(value = "SELECT id FROM ACCOUNTS WHERE username=:username", nativeQuery = true)
    public int getIdByUsername(@Param("username") String username);
}
