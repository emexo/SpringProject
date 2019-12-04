package com.tim.util;

public class UtilClient {

	public static void main(String[] args) {
		RegistrationUtil regUtil=new RegistrationUtil();
		//regUtil.getAllRegistrationUtil();
		//regUtil.getByIdRegistrationUtil();
	//	regUtil.saveRegistrationUtil();
		//regUtil.updateRegistrationUtil();
		//regUtil.deleteRegistrationUtil();

		CourseUtil course=new CourseUtil();
		//course.deleteCourseByIdUtil();
		course.getAllCourseUtil();
		//course.getByIdCourseUtil();
		//course.saveCourseUtil();
		//course.updateCourseUtil();
	}

}
