package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.HotelInfo;

import com.example.demo.repo.Hotel_InfoRepositary;

@Service(value = "hotelInfoService")
public class HotelInfoService {
	private Hotel_InfoRepositary repo;

	public HotelInfoService(Hotel_InfoRepositary repo) {
		super();
		this.repo = repo;
	}

	public HotelInfo save(HotelInfo info) {
		return this.repo.save(info);

	}

	public List<HotelInfo> findByName(String name) {
		return this.repo.findByName(name);
	}

	public List<HotelInfo> findByMenuType(String menu) {
		return this.repo.findByMenuType(menu);
	}

	public List<HotelInfo> findByServiceArea(String area) {
		return this.repo.findByServiceArea(area);
	}

	public List<HotelInfo> findAreaByMenuType(String area, String menu) {
		return this.repo.findByAreaAndMenuType(area, menu);
	}

	public List<HotelInfo> findAllHotel() {
		return this.repo.findAll();
	}
	public Optional<HotelInfo> findById(int id) {
		return this.repo.findById(id);
	}

	public void deleteById(int id) {

		this.repo.deleteById(id);
	}
	public HotelInfo updateById(int id) {
		return this.repo.updateById(id);
	}
	

}
