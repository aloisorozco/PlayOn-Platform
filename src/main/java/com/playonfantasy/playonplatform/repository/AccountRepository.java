package com.playonfantasy.playonplatform.repository;

import com.playonfantasy.playonplatform.model.Account;
import com.playonfantasy.playonplatform.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    public Account findByUsername(String username);

    public Account findByEmailAndPassword(String email, String password);
}
