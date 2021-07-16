package com.igor.igor.repositories;

import com.igor.igor.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository<Address, Integer> {

}