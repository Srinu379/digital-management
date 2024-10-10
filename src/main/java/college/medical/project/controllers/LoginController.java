package college.medical.project.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.UserLoginDto;
import college.medical.project.servicelayer.Validation;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	private Validation validateLogin = new Validation();
	
	@RequestMapping("/login")
	public String getLogin(@ModelAttribute("userLogin") UserLoginDto user) {
		
		return "login";
	}
	
	@RequestMapping("/process-login") 
	public String processLogin(@Valid @ModelAttribute("userLogin") UserLoginDto user,BindingResult result,HttpSession session,Model model) 
	{
		
		if(result.hasErrors())
		{
			
			return "login";
		}
		
//		try {
			UserLoginDto userInfo = userDaoImpl.getUserDetails(user.getEmail());
			if(!validateLogin.validateLogin(user,userInfo))
			{
				
				model.addAttribute("errorMessage","Your username or password is invalid");
				return "login";
			}
			
			session.setAttribute("email",user.getEmail());
			session.setAttribute("userName",user.getUserName());
			session.setMaxInactiveInterval(1800);
			
			int totalCount = userDaoImpl.getCount();
			model.addAttribute("totalCount",totalCount);
			
			int maleCount = userDaoImpl.getMaleCount();
			model.addAttribute("maleCount",maleCount);
			
			int femaleCount = userDaoImpl.getFemaleCount();
			model.addAttribute("femaleCount",femaleCount);
			
			return "homepage";	
//		}
//		catch(Exception e) {
//			
//			model.addAttribute("errorMessage","Your username or password is invalid");
//			return "login-page";
//		}
	}
}
