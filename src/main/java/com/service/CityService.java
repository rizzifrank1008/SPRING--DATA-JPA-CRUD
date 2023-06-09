package com.service;

import com.entity.City;
import com.entity.Country;

public interface CityService {
	public void checkInsertOrUpdateCity(City city);

	public void checkFindCityByCountry(Country country);
}
