package com.prc.ss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prc.ss.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
