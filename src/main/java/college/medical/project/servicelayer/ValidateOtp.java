package college.medical.project.servicelayer;

public class ValidateOtp {

	public boolean valid(String otp,String userOtp)
	{
		if(otp.equals(userOtp))
			return true;
		else
			return false;
	}
	
}
