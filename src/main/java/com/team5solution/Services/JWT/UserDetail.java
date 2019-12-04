package com.team5solution.Services.JWT;

import com.team5solution.Facades.AccountFacade;
import com.team5solution.Entities.Account;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetail implements UserDetailsService {

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            AccountFacade dto = new AccountFacade();
            Account account = dto.getByUsername(username);
            if (account == null) {
                throw new Exception();
            }
//      if(account.getRole()==false)
            AccountPrinciple principle = AccountPrinciple.build(account);
            return principle;
        } catch (Exception ex) {
            throw new UsernameNotFoundException("User not found with -> username or password " + username);
        }
    }

}
