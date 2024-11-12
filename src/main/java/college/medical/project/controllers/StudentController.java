package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.StudentIssueDto;
import college.medical.project.DTO.UserIdDto;

@Controller
public class StudentController {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/student-register-form")
	public String getStudentRegisterForm(Model model,StudentIssueDto studentIssue)
	{
		List<MedicineDto> medicines  = userDaoImpl.getAllMedicines();
		
		model.addAttribute("medicines",medicines);
		model.addAttribute("studentIssue",studentIssue);
		
		return "book-form";
	}
	
	@RequestMapping("/process-student-form")
	public String processStudentForm(StudentIssueDto student,Model model)
	{
		int count = 0;
		for(String medicine : student.getAllMedicines().split(" "))
		{
			MedicineDto Medicine = userDaoImpl.getMedicine(medicine);
			if(Medicine.getQuantity()==0)
			{
				model.addAttribute("notAvailable","medicine is notAvailable");
				return "book-form";
			}
			else
			{
				count++;
				System.out.println(Medicine.getQuantity() + "-------------------------------count:"+count);
				
				Medicine.setQuantity(Medicine.getQuantity()-1);
				
				System.out.println(Medicine.getQuantity() + "-------------------------------");
				
				userDaoImpl.medicineUpdateQuantity(Medicine);
			}
		}
		
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
	
	@RequestMapping("/view-student-issues")
	public String getAllStudentsIssues(Model model)
	{
		
		List<StudentIssueDto> students = userDaoImpl.getAllIssues();
		
		model.addAttribute("students",students);
		
		return "student-issues";
	}
	
	@RequestMapping("/search-student")
	public String getStudentDetails(Model model,UserIdDto user)
	{
		
		List<StudentIssueDto> student = userDaoImpl.getStudentIssues(user.getId());
		
		model.addAttribute("students",student);
		
		return "student-issues";
	}

}
