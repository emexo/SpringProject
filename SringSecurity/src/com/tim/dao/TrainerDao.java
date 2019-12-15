package com.tim.dao;

import java.util.List;

import com.tim.domain.Course;
import com.tim.domain.Trainer;

public interface TrainerDao {
	public void insertTrainer(Trainer trainer);
	public int deleteTrainer(int trainerId) ;
	public int updateTrainer(Trainer trainer);
	public List<Trainer> getAllTrainer() ;
	public Trainer getTrainerById(int trainerId);
}
