package com.company.cpluss.service;

import com.company.cpluss.model.userInfo.Role;
import com.company.cpluss.model.userInfo.User;
import com.company.cpluss.repository.AddressRepo;
import com.company.cpluss.repository.RoleRepository;
import com.company.cpluss.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepo addressRepo;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, AddressRepo addressRepo, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.addressRepo = addressRepo;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(User user){
        user.setRoles(List.of(Role.builder().roleName("ROLE_USER").build()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        roleRepository.saveAll(user.getRoles());
        addressRepo.saveAll(user.getAddresses());
        return userRepository.save(user);
    }


    public List<User> viewUsersList(){
        return userRepository.findAll();
    }
}
