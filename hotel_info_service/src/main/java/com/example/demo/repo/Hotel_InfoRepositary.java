package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.HotelInfo;



public interface Hotel_InfoRepositary extends MongoRepository<HotelInfo, Integer> {
	
	List<HotelInfo> findByName(String name);
	List<HotelInfo> findByMenuType(String menuType);
	List<HotelInfo> findByServiceArea(String serviceArea);
	
	
	//List<HotelInfo> findByMenuTypeAndServiceArea(String area,String menu);
	
	@Query("{area : ?0,menuType : ?1}")
	List<HotelInfo> findByAreaAndMenuType(String area,String menu);
	HotelInfo updateById(int id);
	

}
