package com.springsecuritywithjwt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecuritywithjwt.Entity.Vehicle;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
	
	Vehicle findByUsername(String username);
	
	Vehicle findByVehicleNum(int vehicleNum);


}
