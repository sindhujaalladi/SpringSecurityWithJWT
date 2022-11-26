package com.springsecuritywithjwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecuritywithjwt.Entity.Vehicle;
import com.springsecuritywithjwt.Repository.VehicleRepository;

@Service
public class VehicleUserDetailsService implements UserDetailsService{
	
	@Autowired
	private VehicleRepository vehiclerepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Vehicle vehicle = vehiclerepository.findByUsername(username);
		if(vehicle == null) {
			throw new UsernameNotFoundException("user not found");
		} 
		return new VehicleUserDetails(vehicle);
	}

}
