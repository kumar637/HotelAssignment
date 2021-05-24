package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.HotelInfo;
import com.example.demo.service.HotelInfoService;

@RestController
@RequestMapping(path = "/hotelinfo/")
@CrossOrigin(origins = "*")
public class HotelInfo_Controller {
	
	private HotelInfoService service;

	public HotelInfo_Controller(HotelInfoService service) {
		super();
		this.service = service;  // contructor dependency injection
		
	}

	@PostMapping(path = "/new")
	public HotelInfo addHotel(@RequestBody HotelInfo info) {
	return this.service.save(info);
	}
	@GetMapping(path = "/srch/names/{name}")
	public List<HotelInfo> getByName(@PathVariable("name") String name){    //-------------> done
		return this.service.findByName(name);
		
	}
	@GetMapping(path = "/srch/menutypes/{menu}")
	public List<HotelInfo> getByMenuType(@PathVariable("menu") String menu){  //-------------> done
		return this.service.findByMenuType(menu);
		
	}
	@GetMapping(path = "/srch/areas/{area}")
	public List<HotelInfo> getByServiceArea(@PathVariable("area") String area){  //-------------> done
		return this.service.findByServiceArea(area);
		
	}
	// findByAreaAndMenutype
	
	@GetMapping(path = "/srch/{area}/{menutype}")    //------------->  not yet done
	public List<HotelInfo> getAreaByMenuType(@PathVariable("area") String area,@PathVariable("menutype") String menu){
		return this.service.findAreaByMenuType(area, menu);
	}
	@GetMapping(path = "/hotels")
	public List<HotelInfo> getAllHotels(){         //-------------> done
		return this.service.findAllHotel();
	}
	
	@PutMapping(path = "/update/{id}")
	public HotelInfo updateById(@PathVariable("id") int id){
		return this.service.updateById(id);
		
	}

	@DeleteMapping(path = "/delete/{id}")
	public HotelInfo deleteById(@PathVariable("id") int id) {
		Optional<HotelInfo> entity = this.service.findById(id);
		HotelInfo delete = null;
		if(entity.isPresent()) {
			delete = entity.get();
			this.service.deleteById(id);
			
		}else {
			throw new NoSuchElementException("Delete Id is empty");
			
		}
		return delete;
		
	}
	}
