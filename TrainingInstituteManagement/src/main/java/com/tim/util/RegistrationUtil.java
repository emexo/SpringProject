package com.tim.util;

import java.net.URI;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tim.domain.Registration;

public class RegistrationUtil {
	
public void getAllRegistrationUtil() {
	RestTemplate template=new RestTemplate();
	final String regUrl="http://localhost:8080/registration/getAll";
	String result=template.getForObject(regUrl, String.class);
	System.out.println(result);
}
public void getByIdRegistrationUtil() {
	RestTemplate template=new RestTemplate();
	final String regUrl="http://localhost:8080/registration/getById?registrationId=13";
	String result=template.getForObject(regUrl, String.class);
	System.out.println(result);
}
public void saveRegistrationUtil() {
	RestTemplate template=new RestTemplate();
	final String regUrl = "http://localhost:8080/registration/save";
	try {
    URI uri = new URI(regUrl);
    Calendar cal=Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, 45);
    Date endDate=cal.getTime();
    Registration registration=new Registration();
    registration.setStudentId(1);
    registration.setCourseId(2);
    registration.setTrainerId(3);
    registration.setCourseStartDate(new Date());
    registration.setCourseEndDate(endDate);
    registration.setBatchTime("4 PM");
    registration.setCourseFee(9000);
    registration.setDate(new Date());
    registration.setStatus("Not Started");
    registration.setWeekdaysWeekend("Weekend");
   
    HttpHeaders headers = new HttpHeaders();

    HttpEntity<Registration> request = new HttpEntity<>(registration, headers);

    ResponseEntity<String> result = template.postForEntity(uri, request, String.class);
    System.out.println("Record Inserted Successfully:"+result);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	public void updateRegistrationUtil() {
		RestTemplate template=new RestTemplate();
		final String regUrl = "http://localhost:8080/registration/update";
		try {
	    URI uri = new URI(regUrl);
	    Calendar cal=Calendar.getInstance();
	    cal.add(Calendar.DAY_OF_MONTH, 30);
	    Date endDate=cal.getTime();
	    Registration registration=new Registration();
	    registration.setRegistrationId(13);
	    registration.setCourseStartDate(new Date());
	    registration.setCourseEndDate(endDate);
	   
	    HttpHeaders headers = new HttpHeaders();

	    HttpEntity<Registration> request = new HttpEntity<>(registration, headers);
	    template.put(uri, request);
	    System.out.println("Record Updated Successfully:");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void deleteRegistrationUtil() {
		RestTemplate template=new RestTemplate();
		final String regUrl="http://localhost:8080/registration/delete/11";
		try {
		URI uri=new URI(regUrl);
		template.delete(uri);
		System.out.println("Record Deleted Sccessfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}

}
