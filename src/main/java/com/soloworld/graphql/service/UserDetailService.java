package com.soloworld.graphql.service;

import com.soloworld.graphql.config.LoginDetails;
import com.soloworld.graphql.entity.UserDetail;
import com.soloworld.graphql.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {

    UserRepository userRepository;


    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        List<UserDetail> userDetails = userRepository.getByEmail(username);

        if (CollectionUtils.isEmpty(userDetails)) {
            throw new UsernameNotFoundException("Login was not suces");
        }
        return new LoginDetails(userDetails.get(0));
    }
}
