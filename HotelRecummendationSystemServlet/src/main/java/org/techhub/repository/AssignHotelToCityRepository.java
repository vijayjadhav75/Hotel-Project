package org.techhub.repository;

import java.util.*;

import org.techhub.model.CityModel;
import org.techhub.model.HotelModel;

public class AssignHotelToCityRepository extends DBConfig {
	List<HotelModel> assign=new ArrayList<HotelModel>();

	public List<HotelModel> assignHotelToCity() {
		try {
			stmt = conn.prepareStatement(
					"select c.cityname, h.name as 'CityHotelName' from city c inner join hotelinfo hi on c.cid = hi.cid inner join hotel h on hi.id = h.id;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				HotelModel hModel = new HotelModel();
				CityModel cModel = new CityModel();
				hModel.setName(rs.getString(1));
				cModel.setCityname(rs.getString(2));
				this.assign.add(hModel);
			}
			return assign;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}

	}
}
