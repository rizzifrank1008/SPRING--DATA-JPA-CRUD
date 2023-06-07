package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.entity.City;
import com.entity.Country;

public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("SELECT c FROM City c WHERE c.country = :country")
	public List<City> FindCityByCountry(Country country);
}
