package com.company.cpluss.repository;

import com.company.cpluss.model.userInfo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
