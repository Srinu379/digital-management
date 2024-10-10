package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.StudentIssueDto;

@Controller
public class IssueController {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/view-all-issues")
	public String getAllIssue(Model model)
	{
		
		List<StudentIssueDto> students = userDaoImpl.getAllIssues();
		
		model.addAttribute("students",students);
		
		return "issues";
	}
	
	@RequestMapping("/view-male-issues")
	public String getCompletedIssue(Model model)
	{
		List<StudentIssueDto> students = userDaoImpl.getMaleIssues();
		
		model.addAttribute("students",students);
		
		return "issues";
	}
	
	@RequestMapping("/view-female-issues")
	public String getPendingIssue(Model model)
	{
		
		List<StudentIssueDto> students = userDaoImpl.getFemaleIssues();
		
		model.addAttribute("students",students);
		
		return "issues";
	}

}
