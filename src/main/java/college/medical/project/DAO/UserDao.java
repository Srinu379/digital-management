package college.medical.project.DAO;

import java.util.List;

import college.medical.project.DTO.FacultyIssueDto;
import college.medical.project.DTO.ForgotPasswordDto;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.MedicineUpdateDto;
import college.medical.project.DTO.NonTeachingStaffDto;
import college.medical.project.DTO.StudentIssueDto;
import college.medical.project.DTO.UpdatePasswordDto;
import college.medical.project.DTO.UserDto;
import college.medical.project.DTO.UserLoginDto;

public interface UserDao {
	
	void insert(UserDto user);
	
	void insertStudent(StudentIssueDto student);
	
	void insertFaculty(FacultyIssueDto faculty);
	
	void insertStaff(NonTeachingStaffDto staff);
	
	void insertIssue(StudentIssueDto student);
	
	void insertFacultyIssue(FacultyIssueDto faculty);
	
	void insertStaffIssue(NonTeachingStaffDto staff);
	
	void insertMedicine(MedicineDto medicine);
	
	UserLoginDto getUserDetails(String email);
	
	UserDto getUserDetailsByEmail(String email);
	
	boolean getStudentId(String rollNo);
	
	boolean getFacultyId(String rollNo);
	
	boolean getStaffId(String id);
	
	List<StudentIssueDto> getAllIssues();
	
	List<FacultyIssueDto> getAllFacultyIssues();
	
	List<NonTeachingStaffDto> getAllStaffIssues();
	
	List<StudentIssueDto> getMaleIssues();
	
	List<FacultyIssueDto> getFacultyMaleIssues();
	
	List<NonTeachingStaffDto> getNonteachingMaleIssues();
	
	List<StudentIssueDto> getFemaleIssues();
	
	List<FacultyIssueDto> getFacultyFemaleIssues();
	
	List<NonTeachingStaffDto> getNonTeachingFemaleIssues();
	
	List<MedicineDto> getMedicines();
	
	int getCount();
	
	int getMaleCount();
	
	int getFemaleCount();
	
	boolean updatePassword(ForgotPasswordDto user);
	
	boolean updateQuantity(MedicineUpdateDto medicine);
	
	boolean changePassword(UpdatePasswordDto user);
	
	boolean setNewPassword(UpdatePasswordDto user);
	
	MedicineDto getMedicine(String medicine);
	
	void medicineUpdateQuantity(MedicineDto medicine);
	
	boolean deleteMedicine(int id);
	
	void setLastLogin(String email);
	
	List<MedicineDto> getAllMedicines();
	
	List<StudentIssueDto> getStudentIssues(String id);
	
	List<FacultyIssueDto> getFacultyIssues(String id);
	
	List<NonTeachingStaffDto> getStaffIssues(String id);
}
