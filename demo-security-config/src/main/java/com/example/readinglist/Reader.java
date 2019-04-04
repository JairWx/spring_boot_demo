package com.example.readinglist;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collection;

@Data
@Entity
public class Reader implements UserDetails {
    @Id
    private String username;
    private String fullname;
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //授予READER权限
        return Arrays.asList(new SimpleGrantedAuthority("READER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        //设置账号不过期
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        //设置账号不加锁
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        //设置证书不过期
        return true;
    }
    @Override
    public boolean isEnabled() {
        //设置不禁用
        return true;
    }


}
