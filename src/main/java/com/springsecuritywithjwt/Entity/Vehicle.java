package com.springsecuritywithjwt.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Vehicle")
public class Vehicle {
	
	
	
	@Id
	private  int vehicleNum;
	
	@Column(name= "VehicleName")
	private String vehiclename;
	
	@Column(name= "UserName")
	private String username;
	
	@Column(name= "Password")
	private String password;
	
	@Column(name= "VehicleLocation")
	private String vehiclelocation;
	 

}
