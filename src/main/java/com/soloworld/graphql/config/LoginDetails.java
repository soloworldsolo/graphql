package com.soloworld.graphql.config;

import com.soloworld.graphql.entity.UserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LoginDetails implements UserDetails {

    private UserDetail userDetail;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        return grantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return userDetail.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetail.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public LoginDetails(UserDetail userDetail) {
        this.userDetail = userDetail;
    }
}
