package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Country;
import com.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CountryRepository countryRepository;

	@Override
	public void checkInsertOrUpdateCountry(Country country) {
		try {
			countryRepository.save(country);
			log.info("Inserimento o aggiornamento Paese riuscito");
		} catch (Exception e) {
			log.info("Inserimento o aggiornamento Paese fallito");
			e.printStackTrace();
		}
	}

}
