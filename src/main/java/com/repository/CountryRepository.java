package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
