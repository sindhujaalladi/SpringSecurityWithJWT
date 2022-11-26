package com.springsecuritywithjwt.service;

import com.springsecuritywithjwt.pojo.VehicleDTO;

public interface VehicleService {
	
	void addVehicleData(VehicleDTO vehicle);
	
	VehicleDTO getVehicleinfo(int vehiclenum);

}
