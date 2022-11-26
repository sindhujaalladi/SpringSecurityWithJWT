package com.springsecuritywithjwt.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springsecuritywithjwt.Entity.Vehicle;

public class VehicleUserDetails implements UserDetails{
	
	private Vehicle vehicle;
	
	VehicleUserDetails(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("ADMIN"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return vehicle.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return vehicle.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
