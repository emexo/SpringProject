package com.tim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.tim.TrainingInstituteManagement;
import com.tim.domain.Trainer;

@Repository(value="trainerDao")
public class TrainerDaoImpl implements TrainerDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LogManager.getLogger(TrainerDaoImpl.class.getName());
	
	public void insertTrainer(Trainer trainer) {
		try {
		String query = "INSERT INTO Trainer(trainer_name,experience,skillset,availability,date) VALUES(?,?,?,?,?)";
		jdbcTemplate.update(query,trainer.getTrainerName(),trainer.getExperience(),trainer.getSkillset(),
				trainer.getAvailability(),new Date());
		LOGGER.info("Record Inserted Successfully");
		}catch(Exception e) {
			e.printStackTrace();
			LOGGER.error("Record Not Inserted",e);
			
		}

	}

	public int deleteTrainer(int trainerId) {
		int result=0;
		try {
		String query = "DELETE FROM Trainer WHERE trainer_id=?";
		 result = jdbcTemplate.update(query, trainerId);
		LOGGER.info("Record Deleted Successfully", result);
		}catch(Exception e) {
			LOGGER.error("Record Not Found", e);
		}
		return result;
	}

//	public int getCount() {
//		String query = "Select count(*) from Student";
//		return jdbcTemplate.queryForObject(query, Integer.class);
//	}
public int updateTrainer(Trainer trainer){
	int result=0;
	try {
	String query="UPDATE Trainer SET trainer_name=?,availability=? WHERE trainer_id=?";
	 result=jdbcTemplate.update(query, trainer.getTrainerName(),trainer.getAvailability(),trainer.getTrainerId());
	LOGGER.info("Record Updated Successfully", result);
	}catch(Exception e) {
		LOGGER.error("Record Not Updated", e);
	}
	return result;
}
	public List<Trainer> getAllTrainer() {
		String query = "Select * from Trainer";

		return jdbcTemplate.query(query, new RowMapper<Trainer>() {

			public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Trainer trainer = new Trainer();
				try {
				trainer.setTrainerId(rs.getInt("trainer_id"));
				trainer.setTrainerName(rs.getString("trainer_name"));
				trainer.setExperience(rs.getString("experience"));
				trainer.setSkillset(rs.getString("skillset"));
				trainer.setAvailability(rs.getString("availability"));
				trainer.setDate(rs.getDate("date"));
				LOGGER.info("Fetched records");
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return trainer;
			}

		});
	}

	public Trainer getTrainerById(int trainerId) {
		String query = "Select * from Trainer where trainer_id=?";
		
		return jdbcTemplate.queryForObject(query, new Object[] { trainerId }, new RowMapper<Trainer>() {

			public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Trainer trainer = new Trainer();
				try {
				trainer.setTrainerId(rs.getInt("trainer_id"));
				trainer.setTrainerName(rs.getString("trainer_name"));
				trainer.setExperience(rs.getString("experience"));
				trainer.setSkillset(rs.getString("skillset"));
				trainer.setAvailability(rs.getString("availability"));
				trainer.setDate(rs.getDate("date"));
				LOGGER.info("Fetched records");
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return trainer;
			}
		});

	}
}
