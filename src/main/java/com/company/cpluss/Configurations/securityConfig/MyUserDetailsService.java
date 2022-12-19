package com.company.cpluss.Configurations.securityConfig;

import com.company.cpluss.repository.UserRepository;
import com.company.cpluss.model.userInfo.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<com.company.cpluss.model.userInfo.User> authuser = userRepository.findByUsername(userName);
        authuser.orElseThrow(()-> new UsernameNotFoundException("user does not exist"));

        List<GrantedAuthority> authorities = authuser
                .get().getRoles().stream()
                .map(Role::getRoleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(authuser.get().getUsername(), authuser.get().getPassword(), authorities);
    }


}