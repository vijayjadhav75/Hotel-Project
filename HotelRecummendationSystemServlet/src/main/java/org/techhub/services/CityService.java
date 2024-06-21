package org.techhub.services;

import java.util.List;

import org.techhub.model.CityModel;
import org.techhub.repository.CityRepository;

public class CityService {
	CityRepository cityRepo=new CityRepository();
	public boolean isAddCity(CityModel model) {
		return cityRepo.isAddCity(model);
	}
	public List<CityModel> getAllCities(){
		return cityRepo.getAllCities();
	}
	public boolean isDeleteCity(int cid) {
		return cityRepo.isDeleteCity(cid);
	}
	public boolean isUpdateCity(CityModel model) {
		return cityRepo.isUpdateCity(model);
	}
}