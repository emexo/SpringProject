package com.tim.domain;

import java.util.Date;

public class Registration {

	private int registrationId; 
	private int studentId ;
	private int courseId ;
	private int trainerId ;
	private Date courseStartDate ;
	private Date courseEndDate ;
	private String weekdaysWeekend ;
	private String batchTime ;
	private String status ;
	private float courseFee ;
	private Date date ;
	public int getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public Date getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public Date getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(Date courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getWeekdaysWeekend() {
		return weekdaysWeekend;
	}
	public void setWeekdaysWeekend(String weekdaysWeekend) {
		this.weekdaysWeekend = weekdaysWeekend;
	}
	public String getBatchTime() {
		return batchTime;
	}
	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public float getCourseFee() {
		return courseFee;
	}
	public void setCourseFee(float courseFee) {
		this.courseFee = courseFee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/*
	 * @Override public String toString() { return
	 * "[registrationId:"+getRegistrationId()+"studentId:"+getStudentId()+
	 * "courseId:"+getCourseId()+ "trainerId:"+getTrainerId()+
	 * "courseStartDate:"+getCourseStartDate()+ "courseEndDate:"+getCourseEndDate()+
	 * "weekdaysWeekend:"+getWeekdaysWeekend()+ "batchTime:"+getBatchTime()+
	 * "status:"+getStatus()+ "courseFee:"+getCourseFee()+"date:"+getDate()+"]"; }
	 */
}
