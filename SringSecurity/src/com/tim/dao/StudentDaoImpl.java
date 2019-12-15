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

import com.tim.domain.Student;


@Repository(value = "StudentDao")
public class StudentDaoImpl  implements StudentDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final Logger LOGGER = LogManager.getLogger(StudentDaoImpl.class.getName());
	public void insertStudent(Student student) {
		try {
		String query = "INSERT INTO Student(first_name, last_name, mobile ,email_id ,gender ,experience ,course , availability ,mode , date)  VALUES(?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,student.getFirstName(),student.getLastName(),student.getMobile(),
				student.getEmailId(),student.getGender(),student.getExperience(),student.getCourse(),student.getAvailability(),
				student.getMode(),new Date());
		LOGGER.info("Record Inserted Successfully");
		}catch(Exception e) {
			LOGGER.error("Error occured while inserting record",e);
		}

	}

	public int deleteStudent(int studentId) {
		int result=0;
		try {
		String query = "DELETE FROM Student WHERE student_id=?";
		 result = jdbcTemplate.update(query, studentId);
		LOGGER.info("Record deleted successfully",result);
		}
		catch(Exception e) {
			LOGGER.error("Record Not Found", e);
		}
		return result;
	}

//	public int getCount() {
//		String query = "Select count(*) from Student";
//		return jdbcTemplate.queryForObject(query, Integer.class);
//	}
public int updateStudent(Student student){
	int result=0;
	try {
	String query="UPDATE Student SET first_name=?,last_name=? WHERE student_id=?";
	 result=jdbcTemplate.update(query, student.getFirstName(),student.getLastName(),student.getStudentId());
	 LOGGER.info("Record Updated Successfully", result);
	}catch(Exception e) {
		LOGGER.error("Record not Updated",e);
	}
	return result;
}
	public List<Student> getAllStudents() {
		
		String query = "Select * from Student";
		return jdbcTemplate.query(query, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				try {
				
				student.setStudentId(rs.getInt("student_id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMobile(rs.getString("mobile"));
				student.setEmailId(rs.getString("email_id"));
				student.setGender(rs.getString("gender"));
				student.setExperience(rs.getString("experience"));
				student.setCourse(rs.getString("course"));
				student.setAvailability(rs.getString("availability"));
				student.setMode(rs.getString("mode"));
				student.setDate(rs.getDate("date"));
				
				}catch(Exception e) {
					LOGGER.error("No Records Found", e);
				}
				return student;
		}
		});
		
	}

	public Student getStudentById(int studentId) {
		String query = "Select * from Student where student_id=?";
		
		return jdbcTemplate.queryForObject(query, new Object[] { studentId }, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();
				try {
				student.setStudentId(rs.getInt("student_id"));
				student.setFirstName(rs.getString("first_name"));
				student.setLastName(rs.getString("last_name"));
				student.setMobile(rs.getString("mobile"));
				student.setEmailId(rs.getString("email_id"));
				student.setGender(rs.getString("gender"));
				student.setExperience(rs.getString("experience"));
				student.setCourse(rs.getString("course"));
				student.setAvailability(rs.getString("availability"));
				student.setMode(rs.getString("mode"));
				student.setDate(rs.getDate("date"));
				
				}catch(Exception e) {
					LOGGER.error("No Record Found", e);
				}
				return student;
			}
		});

	}
}

	