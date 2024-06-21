package org.techhub.repository;

import java.util.*;

import org.techhub.model.HotelInfoModel;
import org.techhub.model.HotelModel;

public class HotelRepository extends DBConfig {
	List<HotelModel> list = new ArrayList<HotelModel>();
	List<HotelInfoModel> hlist = new ArrayList<HotelInfoModel>();

	public boolean isAddHotel(HotelModel model) {
		try {
			stmt = conn.prepareStatement("insert into hotel values('0',?)");
			stmt.setString(1, model.getName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<HotelModel> getAllHotels() {
		try {
			stmt = conn.prepareStatement("select * from hotel");
			rs = stmt.executeQuery();
			while (rs.next()) {
				HotelModel model = new HotelModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);
			}
			return list;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	public boolean isDeleteHotel(int hotelId) {
		try {
			stmt = conn.prepareStatement("delete from hotel where id=?");
			stmt.setInt(1, hotelId);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	public boolean isHotelUpdate(HotelModel hotel) {
		try {
			stmt = conn.prepareStatement("update hotel set name=? where id=?");
			stmt.setString(1, hotel.getName());
			stmt.setInt(2, hotel.getId());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}

	public int getHotelId(String name) {
		try {
			stmt = conn.prepareStatement("select id from hotel where name=?");
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception ex) {
			System.out.println("error is " + ex);
			return 0;
		}
	}

	public boolean isAddInfoHotel(HotelInfoModel model) {
		try {
			int hotelId = this.getHotelId(model.getName());
			stmt = conn.prepareStatement("insert into hotelinfo values('0',?,?,?,?,?)");
			stmt.setString(1, model.getGmail());
			stmt.setString(2, model.getContact());
			stmt.setString(3, model.getLocation());
			stmt.setString(4, model.getAddress());
			stmt.setInt(5, hotelId);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}

	public List<HotelInfoModel> getHotelInfo() {
		try {
			stmt = conn.prepareStatement(
					"select h.name,hi.gmail, hi.contact,hi.location,hi.address,hi.iid from hotel h inner join hotelinfo hi on h.id=hi.id;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				HotelInfoModel model = new HotelInfoModel();
				model.setName(rs.getString(1));
				model.setGmail(rs.getString(2));
				model.setContact(rs.getString(3));
				model.setLocation(rs.getString(4));
				model.setAddress(rs.getString(5));
				model.setIid(rs.getInt(6));
				this.hlist.add(model);
			}
			return hlist;
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return null;
		}
	}

	public boolean isDeleteHotelInfo(int Iid) {
		try {
			stmt = conn.prepareStatement("delete from hotelinfo where iid=?");
			stmt.setInt(1, Iid);
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}

	public boolean isHotelInfoUpdate(HotelInfoModel hotel) {
		try {
			stmt = conn.prepareStatement("update hotelinfo set gmail=?,contact=?,location=?,address=? where iid=?");
			stmt.setString(1, hotel.getGmail());
			stmt.setString(2, hotel.getContact());
			stmt.setString(3, hotel.getLocation());
			stmt.setString(4, hotel.getAddress());
			stmt.setInt(5, hotel.getIid());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception ex) {
			return false;
		}
	}
}
