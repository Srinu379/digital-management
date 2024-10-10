package college.medical.project.servicelayer;

import java.util.UUID;

public class RandomId {
	
	public String generateUuid() 
	{
		return UUID.randomUUID().toString();
	}

}
