package com.tim.domain;

import java.util.Date;

public class Trainer {

	private int trainerId ;
	private String trainerName ;
	private String experience ;
	private String skillset; 
	private String availability ;
	private Date date ;
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getSkillset() {
		return skillset;
	}
	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "[trainerId:"+getTrainerId()+"trainerName:"+getTrainerName()+"experience:"+getExperience()+
				"skillset:"+getSkillset()+"availability:"+getAvailability()+"date:"+getDate()+"]";
	}
}
