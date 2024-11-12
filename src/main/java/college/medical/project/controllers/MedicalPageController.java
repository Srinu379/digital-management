package college.medical.project.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping("/delete-medicine")
	public String deleteMedicine(@RequestParam("id") int id,Model model)
	{
		
		userDaoImpl.deleteMedicine(id);
		
		List<MedicineDto> medicines = userDaoImpl.getMedicines();
		
		model.addAttribute("medicines",medicines);
		
		return "medical";
	}
	
	@RequestMapping("/search-medicine")
	public String searchMedicine(@RequestParam("query") String medicineName,Model model)
	{
		
	    MedicineDto medicine = userDaoImpl.getMedicine(medicineName);
		
		model.addAttribute("medicine",medicine);
		
		return "search-medical";
	}
	

}
