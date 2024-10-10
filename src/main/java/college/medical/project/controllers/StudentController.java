package college.medical.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.StudentIssueDto;

@Controller
public class StudentController {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/student-register-form")
	public String getStudentRegisterForm()
	{
		
		return "book-form";
	}
	
	@RequestMapping("/process-student-form")
	public String processStudentForm(StudentIssueDto student)
	{
		
		if(userDaoImpl.getStudentId(student.getRollNo()))
		{
			userDaoImpl.insertIssue(student);
		}
		
		else
		{
			userDaoImpl.insertStudent(student);
			userDaoImpl.insertIssue(student);
		}
		
		return "student-register-successful";
	}
	
	@RequestMapping("/student-register-successful")
	public String getStudentRegisterSuccessfulPage()
	{
		return "student-register-successful";
	}

}
