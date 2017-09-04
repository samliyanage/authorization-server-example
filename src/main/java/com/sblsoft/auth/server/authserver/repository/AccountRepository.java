package com.sblsoft.auth.server.authserver.repository;

import com.sblsoft.auth.server.authserver.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

/**
 * Created by sampathliyanage on 9/5/17.
 */
public interface AccountRepository extends JpaRepository<Account,Long>{

    Optional<Account> findByUsername(String username);
}
