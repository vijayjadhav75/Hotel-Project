package org.techhub.services;

import java.util.List;

import org.techhub.model.HotelInfoModel;
import org.techhub.model.HotelModel;
import org.techhub.repository.HotelRepository;

public class HotelService {
	HotelRepository hotelRepo=new HotelRepository();
	public boolean isAddHotel(HotelModel model) {
		return hotelRepo.isAddHotel(model);
	}
	public List<HotelModel> getAllHotels(){
		return hotelRepo.getAllHotels();
	}
	public boolean isDeleteHotel(int hotelId) {
		return hotelRepo.isDeleteHotel(hotelId);
	}
	public boolean isUpdateHotel(HotelModel model) {
		return hotelRepo.isHotelUpdate(model);
	}
	public boolean isAddInfoHotel(HotelInfoModel model) {
		return hotelRepo.isAddInfoHotel(model);
	}
	public List<HotelInfoModel> getHotelList(){
		return hotelRepo.getHotelInfo();
	}
	public boolean isDeleteHotelInfo(int Iid) {
		return hotelRepo.isDeleteHotelInfo(Iid);
	}	
	public boolean isHotelInfoUpdate(HotelInfoModel hotel) {
		return hotelRepo.isHotelInfoUpdate(hotel);
	}
}
