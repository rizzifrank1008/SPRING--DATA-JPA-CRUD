package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.City;
import com.entity.Country;
import com.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CityRepository cityRepository;

	@Override
	public void checkInsertOrUpdateCity(City city) {
		try {
			cityRepository.save(city);
			log.info("Inserimento o aggiornamento riuscito");
		} catch (Exception e) {
			log.info("Inserimento o aggiornamento fallito");
			e.printStackTrace();
		}

	}

	@Override
	public void checkFindCityByCountry(Country country) {
		List<City> cities = cityRepository.FindCityByCountry(country);
		if (cities != null && !cities.isEmpty()) {
			log.info("lettura eseguita");
			cities.forEach(System.out::println);
		} else {
			log.info("lettura fallita");
		}

	}

}
