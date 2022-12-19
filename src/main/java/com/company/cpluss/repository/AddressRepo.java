package com.company.cpluss.repository;

import com.company.cpluss.model.userInfo.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
