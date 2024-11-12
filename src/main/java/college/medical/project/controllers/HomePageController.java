package college.medical.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.ForgotPasswordDto;
import college.medical.project.DTO.UpdatePasswordDto;
import college.medical.project.DTO.UserLoginDto;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomePageController {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/e-homepage")
	public String getHomePage(Model model)
	{
		
		
		int totalCount = userDaoImpl.getCount();
		model.addAttribute("totalCount",totalCount);
		
		int maleCount = userDaoImpl.getMaleCount();
		model.addAttribute("maleCount",maleCount);
		
		int femaleCount = userDaoImpl.getFemaleCount();
		model.addAttribute("femaleCount",femaleCount);

		return "homepage";
	}
	
	@RequestMapping("/get-forms")
	public String getBothForms()
	{
		return "services";
	}
	
	@RequestMapping("/profile-page")
	public String getPerformancePage(Model model,HttpSession session)
	{
		String email = (String) session.getAttribute("email");
		
		UserLoginDto user = userDaoImpl.getUserDetails(email);
		
		model.addAttribute("users",user);
		
		return "profile";
	}
	
	@RequestMapping("/forgot-password")
	public String getForgotPasswordPage()
	{
		return "forgot-password";
	}
	
	@RequestMapping("/process-forgot-password")
	public String processForgotPassword(ForgotPasswordDto userForgotPassword,Model model)
	{ 
		boolean update = userDaoImpl.updatePassword(userForgotPassword);
		
		if(!update) {
			
			model.addAttribute("userDoesNotExist","Email not found please enter a valid email");
			
			return "forgot-password";
		}
			
		return "update-successful";
	}
	
	@RequestMapping("/change-password")
	public String getChangePasswordPage()
	{
		return "change-password";
	}
	
	@RequestMapping("/process-change-password")
	public String processChangePassword(UpdatePasswordDto userEnteredInfo)
	{
		
		System.out.println(userEnteredInfo.getEmail());
		System.out.println(userEnteredInfo.getPassWord());
		
		if(!userDaoImpl.changePassword(userEnteredInfo))
		{
		  return "change-password";
		}
		
		return "update-successful";
	}
	
	@RequestMapping("/contact-us")
	public String getContactPage()
	{	
		return "contact-us";
	}
	
	@RequestMapping("/about-us")
	public String getAboutusPage()
	{	
		return "about-us";
	}
	
}

