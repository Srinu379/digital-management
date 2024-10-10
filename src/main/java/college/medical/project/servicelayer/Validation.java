package college.medical.project.servicelayer;

import college.medical.project.DTO.UpdatePasswordDto;
import college.medical.project.DTO.UserLoginDto;

public class Validation {

	public boolean validateLogin(UserLoginDto user,UserLoginDto userInfo) {
		
		 if(!user.getEmail().equals(userInfo.getEmail()))
				return false;
	
	    if(!user.getUserName().equals(userInfo.getUserName()))
			return false;
		
		else if(!user.getPassWord().equals(userInfo.getPassWord()))
			return false;
		
		return true;
		
	}
	
	public boolean validateChangePassword(UpdatePasswordDto user,UserLoginDto userInfo) {
		
		 if(!user.getEmail().equals(userInfo.getEmail()))
				return false;
	 
		else if(!user.getPassWord().equals(userInfo.getPassWord()))
			return false;
		
		return true;
		
	}
	
}	

