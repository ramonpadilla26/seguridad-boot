package com.uabd.edu.mx.seguridad.service;


import com.uabd.edu.mx.seguridad.config.MyUserDetails;
import com.uabd.edu.mx.seguridad.model.User;
import com.uabd.edu.mx.seguridad.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> obj=repository.findUsersByUsername(userName);

        obj.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return obj.map(MyUserDetails::new).get();
    }
}
