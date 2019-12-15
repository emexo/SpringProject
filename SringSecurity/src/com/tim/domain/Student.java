package com.tim.domain;

import java.util.Date;

public class Student {

	private int studentId ;
	private String firstName;
	private String lastName ;
	private String mobile;
	private String emailId; 
	private String gender ;
	private String experience; 
	private String course ;
	private String availability ;
	private String mode ;
	private Date date ;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "[studentId:"+getStudentId()+"firstName:"+getFirstName()+"lastName"+getLastName()+
				"mobile:"+getMobile()+"emailId:"+getEmailId()+"gender:"+getGender()+
				"experience:"+getExperience()+"course:"+getCourse()+"availability:"+getAvailability()+
				"mode:"+getMode()+"date:"+getDate()+"]";
		}
}
