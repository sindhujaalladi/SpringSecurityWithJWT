package com.springsecuritywithjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsecuritywithjwt.Entity.Vehicle;
import com.springsecuritywithjwt.Repository.VehicleRepository;
import com.springsecuritywithjwt.pojo.VehicleDTO;


@Service
public class VehicleServiceImp implements VehicleService{
	
	
	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public void addVehicleData(VehicleDTO vehicle) {
		Vehicle vehobj = new Vehicle();
		vehobj.setPassword(vehicle.getPassword());
		vehobj.setUsername(vehicle.getUsername());
		vehobj.setVehiclelocation(vehicle.getVehiclelocation());
		vehobj.setVehiclename(vehicle.getVehiclename());
		vehobj.setVehicleNum(vehicle.getVehicleNum());
		vehicleRepository.save(vehobj);
	}

	@Override
	public VehicleDTO getVehicleinfo(int vehiclenum) {
		
		Vehicle veobj = vehicleRepository.findByVehicleNum(vehiclenum);
		VehicleDTO vehdto = new VehicleDTO();
		vehdto.setPassword(veobj.getPassword());
		vehdto.setUsername(veobj.getUsername());
		vehdto.setVehiclelocation(veobj.getVehiclelocation());
		vehdto.setVehiclename(veobj.getVehiclename());
		vehdto.setVehicleNum(veobj.getVehicleNum());
		return vehdto;
	}

}
