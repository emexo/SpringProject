package com.tim.domain;

import java.util.Date;

public class Course {

	private int courseId ;
	private String courseName ;
	private String duration ;
	private float fee;
	private String courseDesc ;
	private String credits ;
	private Date date ;
	
	public Course() {
		
	}
	public Course(String courseName, String duration, float fee, String courseDesc, String credits, Date date) {
		super();
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
		this.courseDesc = courseDesc;
		this.credits = credits;
		this.date = date;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public float getFee() {
		return fee;
	}
	public void setFee(float fee) {
		this.fee = fee;
	}
	public String getCourseDesc() {
		return courseDesc;
	}
	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "[courseId:"+getCourseId()+"courseName:"+getCourseName()+"duration:"+getDuration()+"Fee:"+getFee()+
				"courseDesc:"+getCourseDesc()+"credits:"+getCredits()+"Date:"+getDate()+"]";
	}
}
