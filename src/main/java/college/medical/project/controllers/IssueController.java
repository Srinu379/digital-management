package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.FacultyIssueDto;
import college.medical.project.DTO.NonTeachingStaffDto;
import college.medical.project.DTO.StudentIssueDto;

@Controller
public class IssueController {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/view-all-issues")
	public String getAllIssues(Model model)
	{
		
		List<StudentIssueDto> students = userDaoImpl.getAllIssues();
		List<FacultyIssueDto> faculty = userDaoImpl.getAllFacultyIssues();
		List<NonTeachingStaffDto> staff = userDaoImpl.getAllStaffIssues();
		
		model.addAttribute("students",students);
		model.addAttribute("faculty",faculty);
		model.addAttribute("staff",staff);
		
		return "view-all-issues";
	}
	
	@RequestMapping("/view-male-issues")
	public String getCompletedIssue(Model model)
	{
		List<StudentIssueDto> students = userDaoImpl.getMaleIssues();
		List<FacultyIssueDto> faculty = userDaoImpl.getFacultyMaleIssues();
		List<NonTeachingStaffDto> staff = userDaoImpl.getNonteachingMaleIssues();
		
		model.addAttribute("students",students);
		model.addAttribute("faculty",faculty);
		model.addAttribute("staff",staff);
		
		return "male-issues";
	}
	
	@RequestMapping("/view-female-issues")
	public String getPendingIssue(Model model)
	{
		
		List<StudentIssueDto> students = userDaoImpl.getFemaleIssues();
		List<FacultyIssueDto> faculty = userDaoImpl.getFacultyFemaleIssues();
		List<NonTeachingStaffDto> staff = userDaoImpl.getNonTeachingFemaleIssues();
		
		model.addAttribute("students",students);
		model.addAttribute("faculty",faculty);
		model.addAttribute("staff",staff);
		
		return "female-issues";
	}
	
	@RequestMapping("/view-issues-page")
	public String getIssuesPage(Model model)
	{
		return "issue";
	}

}
