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
import com.tim.domain.Course;

@Repository(value="courseDao")
public class CourseDaoImpl implements CourseDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LogManager.getLogger(CourseDaoImpl.class.getName());
	
	public void insertCourse(Course course) {
		try {
		String query = "INSERT INTO Course(course_name,duration,fee,course_desc,credits,date) VALUES(?,?,?,?,?,?)";
		jdbcTemplate.update(query,course.getCourseName(),course.getDuration(),course.getFee(),
				course.getCourseDesc(),course.getCredits(),new Date());
		LOGGER.info("Record Inserted Successfully");
		}catch(Exception e) {
			LOGGER.error("Record Not Inserted", e);
		}

	}

	public int deleteCourse(int courseId) {
		int result=0;
		try {
		String query = "DELETE FROM Course WHERE course_id=?";
		 result = jdbcTemplate.update(query, courseId);
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
public int updateCourse(Course course){
	int result=0;
	try {
	String query="UPDATE Course SET course_name=?,duration=? WHERE course_id=?";
	 result=jdbcTemplate.update(query, course.getCourseName(),course.getDuration(),course.getCourseId());
	 LOGGER.info("Record Updated Successfully", result);
	}catch(Exception e) {
		LOGGER.error("Record Not Updated", e);
	}
	return result;
}
	public List<Course> getAllCourse() {
		String query = "Select * from Course";

		return jdbcTemplate.query(query, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				try {
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseName(rs.getString("course_name"));
				course.setDuration(rs.getString("duration"));
				course.setFee(rs.getFloat("fee"));
				course.setCourseDesc(rs.getString("course_desc"));
				course.setCredits(rs.getString("credits"));
				course.setDate(rs.getDate("date"));
				LOGGER.info("Fetched records");
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return course;
			}

		});
	}

	public Course getCourseById(int courseId) {
		String query = "Select * from Course where course_id=?";
		
		return jdbcTemplate.queryForObject(query, new Object[] { courseId }, new RowMapper<Course>() {

			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				try {
				course.setCourseId(rs.getInt("course_id"));
				course.setCourseName(rs.getString("course_name"));
				course.setDuration(rs.getString("duration"));
				course.setFee(rs.getFloat("fee"));
				course.setCourseDesc(rs.getString("course_desc"));
				course.setCredits(rs.getString("credits"));
				course.setDate(rs.getDate("date"));
				LOGGER.info("Fetched records");
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return course;
				
			}
		});

	}
}



