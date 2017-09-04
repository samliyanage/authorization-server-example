package com.sblsoft.auth.server.authserver.service;

import com.sblsoft.auth.server.authserver.repository.AccountRepository;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by sampathliyanage on 9/5/17.
 */

@Service
public class AccountUserDetailsService implements UserDetailsService{

    private final AccountRepository accountRepository;

    public AccountUserDetailsService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username)
                .map(account -> new User(account.getUsername(),
                account.getPassword(), account.isActive(), account.isActive(), account.isActive(), account.isActive()
                , AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER")
                ))
                .orElseThrow(()-> new UsernameNotFoundException("Cannot find the username '" +username +"'."))
                ;
    }
}
