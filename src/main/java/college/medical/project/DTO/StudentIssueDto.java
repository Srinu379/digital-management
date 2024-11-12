package college.medical.project.DTO;

public class StudentIssueDto {
	
	private String rollNo;
	private String studentName;
	private String department;
	private String gender;
	private String description;
	private String medicines[];
	private String medicine;
	private String createdAt;
	
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String[] getMedicines() {
		return medicines;
	}
	
	public void setMedicines(String medicines[]) {
		this.medicines = medicines;
	}
	
	public String getMedicine() {
		this.medicine = getAllMedicines();
		return medicine;
	}
	
	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}
	
	public String getAllMedicines() {
		StringBuffer allMedicines = new StringBuffer();
		for(String medicine : medicines)
		{
			allMedicines.append(medicine);
			allMedicines.append(" ");
		}
		System.out.println(allMedicines.toString() + "----------------------");
		return allMedicines.toString();
	}

}

