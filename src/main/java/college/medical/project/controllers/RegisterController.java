package college.medical.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.UserDto;
import jakarta.validation.Valid;

@Controller
public class RegisterController {
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
//	private GetOtp getOtp = new GetOtp();
//	
//	private ValidateOtp validateOtp = new ValidateOtp();
//	
//	private SendMessage message = new SendMessage();
	
//	private int otp;
	
	@RequestMapping("/")
	public String getLandingPage() {
		
		return "landing-page";
	}
	
	@RequestMapping("/register")
	public String getRegister(@ModelAttribute("userRegistration") UserDto userDto) {
		
		return "register";
	}
	
	@RequestMapping("/process-register")
	public String registrationSuccess(@Valid @ModelAttribute("userRegistration") UserDto userDto,BindingResult result,Model model) {
		
		if(result.hasErrors())
		{
				
			return "register";
		}
		
		userDaoImpl.insert(userDto);
		
		return "registration-success";
	}
}
