package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import college.medical.project.DAO.UserDaoImpl;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.MedicineUpdateDto;

@Controller
public class MedicalPageController {

	private UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	@RequestMapping("/view-medical")
	public String getMedicalPage(Model model)
	{
		
		List<MedicineDto> medicines = userDaoImpl.getMedicines();
		
		for(MedicineDto med : medicines)
		{
			System.out.println(med.getMedicineName()+med.getQuantity()+med.getDescription()+med.getCreatedAt());
		}
		
		model.addAttribute("medicines",medicines);
		
		return "medical";
	}
	
	@RequestMapping("/medical-register-form")
	public String getMedicalRegisterForm()
	{
		
		return "medical-register-form";
	}
	
	@RequestMapping("/process-medical-form")
	public String processMedicalForm(MedicineDto medicine)
	{
		userDaoImpl.insertMedicine(medicine);
		return "student-register-successful";
	}
	
	@RequestMapping("/update-page")
	public String getUpdatePage()
	{
		return "update-quantity";
	}
	
	@RequestMapping("/update-medicine-quantity")
	public String processUpdateMedicineQuantity(MedicineUpdateDto medicine)
	{
		System.out.println(medicine.getId());
		System.out.println(medicine.getQuantity());
		
		if(!userDaoImpl.updateQuantity(medicine))
			return "update-quantity";
		
		return "update-medicine-successful";
	}

}
