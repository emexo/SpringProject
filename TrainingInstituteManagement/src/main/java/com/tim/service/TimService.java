package com.tim.service;

import com.tim.dao.CourseDao;
import com.tim.dao.RegistrationDao;
import com.tim.dao.StudentDao;
import com.tim.dao.TrainerDao;
import com.tim.domain.Course;
import com.tim.domain.Registration;
import com.tim.domain.Student;
import com.tim.domain.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("timService")
public class TimService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TrainerDao trainerDao;
    @Autowired
    private RegistrationDao registrationDao;

    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }

    public int deleteStudent(int studentId) {
        return studentDao.deleteStudent(studentId);
    }

    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    public void insertCourse(Course course) {
        courseDao.insertCourse(course);
    }

    public int deleteCourse(int courseId) {
        return courseDao.deleteCourse(courseId);
    }

    public int updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    public Course getCourseById(int courseId) {
        return courseDao.getCourseById(courseId);
    }

    public void insertTrainer(Trainer trainer) {
        trainerDao.insertTrainer(trainer);
    }

    public int deleteTrainer(int trainerId) {
        return trainerDao.deleteTrainer(trainerId);
    }

    public int updateTrainer(Trainer trainer) {
        return trainerDao.updateTrainer(trainer);
    }

    public List<Trainer> getAllTrainers() {
        return trainerDao.getAllTrainer();
    }

    public Trainer getTrainerById(int trainerId) {
        return trainerDao.getTrainerById(trainerId);
    }

    public void insertRegistration(Registration registration) {
        registrationDao.insertRegistration(registration);
    }

    public int deleteRegistration(int registrationId) {
        return registrationDao.deleteRegistration(registrationId);
    }

    public int updateRegistration(Registration registration) {
        return registrationDao.updateRegistration(registration);
    }

    public List<Registration> getAllRegistration() {
        return registrationDao.getAllRegistration();
    }

    public Registration getRegistrationById(int registrationId) {
        return registrationDao.getRegistrationById(registrationId);
    }
}