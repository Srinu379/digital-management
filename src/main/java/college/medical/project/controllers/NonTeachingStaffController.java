package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.FacultyIssueDto;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.NonTeachingStaffDto;
import college.medical.project.DTO.StudentIssueDto;
import college.medical.project.DTO.UserIdDto;

@Controller
public class NonTeachingStaffController {

private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/nonteaching-faculty-register-form")
	public String getFacultyRegistrationForm(Model model,NonTeachingStaffDto staffIssue)
	{

		List<MedicineDto> medicines  = userDaoImpl.getAllMedicines();
		
		model.addAttribute("medicines",medicines);
		model.addAttribute("staffIssue",staffIssue);
		
		return "nonteaching-staff-form";
	}
	
	@RequestMapping("/process-nonteaching-faculty-form")
	public String processStudentForm(Model model,NonTeachingStaffDto staff)
	{
		
		int count = 0;
		for(String medicine : staff.getAllMedicines().split(" "))
		{
			MedicineDto Medicine = userDaoImpl.getMedicine(medicine);
			if(Medicine.getQuantity()==0)
			{
				model.addAttribute("notAvailable","medicine is notAvailable");
				return "nonteaching-staff-form";
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
		
		if(userDaoImpl.getStaffId(staff.getId()))
		{
			userDaoImpl.insertStaffIssue(staff);
		}
		
		else
		{
			userDaoImpl.insertStaff(staff);
			userDaoImpl.insertStaffIssue(staff);
		}
		
		
		return "faculty-registration-successful";
	}
	
	@RequestMapping("/nonteaching-faculty-register-successful")
	public String getStudentRegisterSuccessfulPage()
	{
		return "faculty-registration-successful";
	}
	
	@RequestMapping("/view-non-teaching-staff-issues")
	public String getAllStudentsIssues(Model model)
	{
		
		List<NonTeachingStaffDto> staff = userDaoImpl.getAllStaffIssues();
		
		model.addAttribute("staff",staff);
		
		return "non-teaching-staff-issues";
	}


	@RequestMapping("/search-staff")
	public String getStudentDetails(Model model,UserIdDto user)
	{
		
		List<NonTeachingStaffDto> staff = userDaoImpl.getStaffIssues(user.getId());
		
		model.addAttribute("staff",staff);
		
		return "non-teaching-staff-issues";
	}
	
}
