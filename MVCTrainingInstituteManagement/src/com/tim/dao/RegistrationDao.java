package com.tim.dao;


import java.util.List;

import com.tim.domain.Registration;

public interface RegistrationDao {
	
	public void insertRegistration(Registration registration);
	public int deleteRegistration(int registrationId) ;
	public int updateRegistration(Registration registration);
	public List<Registration> getAllRegistration() ;
	public Registration getRegistrationById(int registrationId); 
}
