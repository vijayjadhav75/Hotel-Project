package org.techhub.repository;

import java.util.*;

import org.techhub.model.CityModel;

public class CityRepository extends DBConfig {
	List<CityModel> cityList = new ArrayList<CityModel>();

	public boolean isAddCity(CityModel model) {
		try {
			stmt = conn.prepareStatement("insert into city values('0',?) ");
			stmt.setString(1, model.getCityname());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	public List<CityModel> getAllCities() {
		try {
			stmt = conn.prepareStatement("select * from city");
			rs = stmt.executeQuery();
			while (rs.next()) {
				CityModel model = new CityModel();
				model.setCid(rs.getInt(1));
				model.setCityname(rs.getString(2));
				cityList.add(model);
			}
			return cityList;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	public boolean isDeleteCity(int cid) {
		try {
			stmt = conn.prepareStatement("delete from city where cid=?");
			stmt.setInt(1, cid);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}
	public boolean isUpdateCity(CityModel model) {
		try {
			stmt = conn.prepareStatement("update city set cityname=? where cid=?");
			stmt.setString(1, model.getCityname());
			stmt.setInt(2, model.getCid());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is "+ex);
			return false;
		}
	}
}