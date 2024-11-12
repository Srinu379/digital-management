package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.FacultyIssueDto;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.StudentIssueDto;
import college.medical.project.DTO.UserIdDto;

@Controller
public class FacultyController {

    private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/faculty-register-form")
	public String getFacultyRegistrationForm(Model model,FacultyIssueDto facultyIssue)
	{

		List<MedicineDto> medicines  = userDaoImpl.getAllMedicines();
		
		model.addAttribute("medicines",medicines);
		model.addAttribute("facultyIssue",facultyIssue);
		
		return "faculty-form";
	}
	
	@RequestMapping("/process-faculty-form")
	public String processStudentForm(Model model,FacultyIssueDto faculty)
	{
		
		int count = 0;
		for(String medicine : faculty.getAllMedicines().split(" "))
		{
			MedicineDto Medicine = userDaoImpl.getMedicine(medicine);
			if(Medicine.getQuantity()==0)
			{
				model.addAttribute("facultyIssue",faculty);
				model.addAttribute("notAvailable","Medicine is Not Available");
				return "faculty-form";
			}
			else
			{
				count++;
				
				Medicine.setQuantity(Medicine.getQuantity()-1);
				
				userDaoImpl.medicineUpdateQuantity(Medicine);
			}
		}
		
		if(userDaoImpl.getFacultyId(faculty.getId()))
		{
			userDaoImpl.insertFacultyIssue(faculty);
		}
		
		else
		{
			userDaoImpl.insertFaculty(faculty);
			userDaoImpl.insertFacultyIssue(faculty);
		}
		
		
		return "faculty-registration-successful";
	}
	
	@RequestMapping("/faculty-register-successful")
	public String getStudentRegisterSuccessfulPage()
	{
		return "faculty-registration-successful";
	}
	

	@RequestMapping("/view-faculty-issues")
	public String getAllStudentsIssues(Model model)
	{
		
		List<FacultyIssueDto> faculty = userDaoImpl.getAllFacultyIssues();
		
		model.addAttribute("faculty",faculty);
		
		return "faculty-issues";
	}

	@RequestMapping("/search-faculty")
	public String getStudentDetails(Model model,UserIdDto user)
	{
		
		List<FacultyIssueDto> faculty = userDaoImpl.getFacultyIssues(user.getId());
		
		model.addAttribute("faculty",faculty);
		
		return "faculty-issues";
	}

}
