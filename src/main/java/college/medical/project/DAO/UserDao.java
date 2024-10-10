package college.medical.project.DAO;

import java.util.List;

import college.medical.project.DTO.ForgotPasswordDto;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.MedicineUpdateDto;
import college.medical.project.DTO.StudentIssueDto;
import college.medical.project.DTO.UpdatePasswordDto;
import college.medical.project.DTO.UserDto;
import college.medical.project.DTO.UserLoginDto;

public interface UserDao {
	
	void insert(UserDto user);
	
	void insertStudent(StudentIssueDto student);
	
	void insertIssue(StudentIssueDto student);
	
	void insertMedicine(MedicineDto medicine);
	
	UserLoginDto getUserDetails(String email);
	
	boolean getStudentId(String rollNo);
	
	List<StudentIssueDto> getAllIssues();
	
	List<StudentIssueDto> getMaleIssues();
	
	List<StudentIssueDto> getFemaleIssues();
	
	List<MedicineDto> getMedicines();
	
	int getCount();
	
	int getMaleCount();
	
	int getFemaleCount();
	
	boolean updatePassword(ForgotPasswordDto user);
	
	boolean updateQuantity(MedicineUpdateDto medicine);
	
	boolean changePassword(UpdatePasswordDto user);
	
	boolean setNewPassword(UpdatePasswordDto user);
}
