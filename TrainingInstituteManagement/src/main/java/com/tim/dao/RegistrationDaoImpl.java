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
import com.tim.domain.Registration;
@Repository(value="registrationDao")
public class RegistrationDaoImpl implements RegistrationDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LogManager.getLogger(RegistrationDaoImpl.class.getName());
	
	public void insertRegistration(Registration registration) {
		try {
		String query = "INSERT INTO Registration(student_id,course_id,trainer_id,course_start_date,course_end_date,weekdays_weekend,Batch_time,status,course_fee,date) VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,registration.getStudentId(),registration.getCourseId(),
				registration.getTrainerId(),registration.getCourseStartDate(),registration.getCourseEndDate(),
				registration.getWeekdaysWeekend(),registration.getBatchTime(),registration.getStatus(),registration.getCourseFee(),
				new Date());
		LOGGER.info("Record Inserted Successfully");
		}catch(Exception e) {
			LOGGER.error("Record Not Inserted",e);
		}

	}

	public int deleteRegistration(int registrationId) {
		int result=0;
		try {
		String query = "DELETE FROM Registration WHERE registration_id=?";
		 result = jdbcTemplate.update(query, registrationId);
		LOGGER.info("Record Deleted Successfully", result);
		}catch(Exception e) {
			LOGGER.error("Record Not Found", e);
		}
		return result;
	}

public int updateRegistration(Registration registration){
	int result=0;
	try {
	String query="UPDATE Registration SET course_start_date=?,course_end_date=? WHERE registration_id=?";
	 result=jdbcTemplate.update(query, registration.getCourseStartDate(),registration.getCourseEndDate(),registration.getRegistrationId());
	LOGGER.info("Record Updated Successfully", result);
	}catch(Exception e) {
		LOGGER.error("Record Not Updated", e);
	}
	return result;
}
	public List<Registration> getAllRegistration() {
		String query = "Select * from Registration";

		return jdbcTemplate.query(query, new RowMapper<Registration>() {

			public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
				Registration registration = new Registration();
				try {
				registration.setRegistrationId(rs.getInt("registration_id"));
				registration.setStudentId(rs.getInt("student_id"));
				registration.setCourseId(rs.getInt("course_id"));
				registration.setTrainerId(rs.getInt("trainer_id"));
				registration.setCourseStartDate(rs.getDate("course_start_date"));
				registration.setCourseEndDate(rs.getDate("course_end_date"));
				registration.setWeekdaysWeekend(rs.getString("weekdays_weekend"));
				registration.setBatchTime(rs.getString("batch_time"));
				registration.setStatus(rs.getString("status"));
				registration.setCourseFee(rs.getFloat("course_fee"));
				registration.setDate(rs.getDate("date"));
				LOGGER.info("Fetched records");
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return registration;
			}

		});
	}

	public Registration getRegistrationById(int registrationId) {
		String query = "Select * from Registration where registration_id=?";
		
		return jdbcTemplate.queryForObject(query, new Object[] { registrationId }, new RowMapper<Registration>() {

			public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
				Registration registration = new Registration();
				try {
				registration.setRegistrationId(rs.getInt("registration_id"));
				registration.setStudentId(rs.getInt("student_id"));
				registration.setCourseId(rs.getInt("course_id"));
				registration.setTrainerId(rs.getInt("trainer_id"));
				registration.setCourseStartDate(rs.getDate("course_start_date"));
				registration.setCourseEndDate(rs.getDate("course_end_date"));
				registration.setWeekdaysWeekend(rs.getString("weekdays_weekend"));
				registration.setBatchTime(rs.getString("batch_time"));
				registration.setStatus(rs.getString("status"));
				registration.setCourseFee(rs.getFloat("course_fee"));
				registration.setDate(rs.getDate("date"));
				LOGGER.info("Fetched records");
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return registration;
			}
		});

	}
}

