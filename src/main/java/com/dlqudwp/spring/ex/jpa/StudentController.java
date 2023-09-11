package com.dlqudwp.spring.ex.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dlqudwp.spring.ex.jpa.domain.Student;
import com.dlqudwp.spring.ex.jpa.service.StudentService;

@RequestMapping("/jpa/student")
@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/create")
	@ResponseBody
	public Student createStudent() {
		
		String name = "김인규";
		String phoneNumber = "010-0000-1111";
		String email = "lecture@hagulu.com";
		String dreamJob = "개발자";
		
		Student student = studentService.addStudent(name, phoneNumber, email, dreamJob);
		
		return student;
		
	}
	
	@GetMapping("/update")
	@ResponseBody
	public Student updateStudent() {
		// id가 4인 학생정보의 장래희망을 강사로 수정
		Student student = studentService.updateStudent(4, "강사");
		 
		 return student;
	}
	
	@GetMapping("/delete")
	@ResponseBody
	public String deleteStudent() {
		
		// id가 3인 학생정보 삭제
		studentService.deleteStudent(3);
		
		return "삭제 성공";
		
		
	}
	
	
	
	
	
	@GetMapping("/lombok/test")
	@ResponseBody
	public Student lombokTest() {
		
//		Student student = new Student();
//		student.setName("이병제");
//		student.setDreamJob("개발자");
//		student.setPhoneNumber("010-1234-5678");
		
		Student student = Student.builder()
							.name("이병제")
							.dreamJob("개발자")
							.phoneNumber("010-0000-3333")
							.build();
		
		
		return student;
	}

}