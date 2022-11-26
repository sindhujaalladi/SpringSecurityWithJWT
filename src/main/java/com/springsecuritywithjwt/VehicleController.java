package com.springsecuritywithjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsecuritywithjwt.pojo.VehicleDTO;
import com.springsecuritywithjwt.service.VehicleService;

@RestController
@RequestMapping("/secure/jwt")
public class VehicleController {
	
	
	@Autowired
	private VehicleService vehicleService;
	
	
	@PostMapping("/addVehicleData")
	public 	String  addVehicleData(@RequestBody VehicleDTO vehicledto) {
		this.vehicleService.addVehicleData(vehicledto);
		return "added data successfully in db";
		//return new ResponseEntity<>(HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{vehicleNum}")
	public ResponseEntity<VehicleDTO> getVehicleinfo(@PathVariable int vehicleNum) {
		VehicleDTO dtoobj = this.vehicleService.getVehicleinfo(vehicleNum);
		return new ResponseEntity<>(dtoobj,HttpStatus.OK);
	}

}
