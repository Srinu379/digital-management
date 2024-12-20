package college.medical.project.DTO;

import jakarta.validation.constraints.NotBlank;

public class UserLoginDto {
	
	@NotBlank(message="your email cannot be blank")
	private String email;
	
	@NotBlank(message="your password cannot be blank")
	private String passWord;

	public String getEmail() {
		
		return email;
	}
	
	public void setEmail(String email) {
		
		this.email = email;
	}
	
	public String getPassWord() {
		
		return passWord;
	}
	
	public void setPassWord(String passWord) {
		
		this.passWord = passWord;
	}
}

