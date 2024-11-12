package college.medical.project.DAO;



import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import college.medical.project.DTO.FacultyIssueDto;
import college.medical.project.DTO.ForgotPasswordDto;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.MedicineUpdateDto;
import college.medical.project.DTO.NonTeachingStaffDto;
import college.medical.project.DTO.StudentIssueDto;
import college.medical.project.DTO.UpdatePasswordDto;
import college.medical.project.DTO.UserDto;
import college.medical.project.DTO.UserIdDto;
import college.medical.project.DTO.UserLoginDto;
import college.medical.project.servicelayer.RandomId;
import college.medical.project.servicelayer.Validation;

@Component
public class UserDaoImpl implements UserDao{

	private JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
	
	private Validation validation = new Validation();
	
	@Override
	public void insert(UserDto user) {
		
		
		String sql = "INSERT INTO users(id,email,userName,passWord,gender,phoneNumber,age) VALUES(?,?,?,?,?,?,?)";
		
		Object object[] = {user.getId(),user.getEmail(),user.getUserName(),user.getPassWord(),user.getGender(),user.getPhoneNumber(),user.getAge()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertStudent(StudentIssueDto student) {
		
		String sql = "INSERT INTO Students(rollNo,studentName,department,gender) VALUES(?,?,?,?)";
		
		Object object[] = {student.getRollNo(),student.getStudentName(),student.getDepartment().toUpperCase(),student.getGender().toLowerCase()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertFaculty(FacultyIssueDto faculty) {
		
		String sql = "INSERT INTO faculty(id,facultyName,department,gender) VALUES(?,?,?,?)";
		
		Object object[] = {faculty.getId(),faculty.getFacultyName(),faculty.getDepartment(),faculty.getGender().toLowerCase()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertStaff(NonTeachingStaffDto staff) {
		
		String sql = "INSERT INTO NonTeachingStaff(id,facultyName,department,gender) VALUES(?,?,?,?)";
		
		Object object[] = {staff.getId(),staff.getFacultyName(),staff.getDepartment(),staff.getGender().toLowerCase()};
		
		jdbcTemplate.update(sql,object);
	}
	
	
	@Override
	public void insertIssue(StudentIssueDto student) {
		
		RandomId random = new RandomId();
		
		String id = random.generateUuid();
		
		String sql = "INSERT INTO Issues(id,rollNo,description,medicines) VALUES(?,?,?,?)";
		
		System.out.println(id+" --------------------------------------");
		
		Object object[] = {id,student.getRollNo(),student.getDescription(),student.getAllMedicines()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertFacultyIssue(FacultyIssueDto faculty) {
		
		RandomId random = new RandomId();
		
		String id = random.generateUuid();
		
		String sql = "INSERT INTO FacultyIssues(id,faculty_id,description,medicines) VALUES(?,?,?,?)";
		
		System.out.println(id+" --------------------------------------");
		
		Object object[] = {id,faculty.getId(),faculty.getDescription(),faculty.getAllMedicines()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertStaffIssue(NonTeachingStaffDto staff) {
		
		RandomId random = new RandomId();
		
		String id = random.generateUuid();
		
		String sql = "INSERT INTO NonTeachingStaffIssues(id,faculty_id,description,medicines) VALUES(?,?,?,?)";
		
		System.out.println(id+" --------------------------------------");
		
		Object object[] = {id,staff.getId(),staff.getDescription(),staff.getAllMedicines()};
		
		jdbcTemplate.update(sql,object);
	}
	
	
	@Override
	public void insertMedicine(MedicineDto medicine) {
		
		String sql = "INSERT INTO Medicines(MedicineName,quantity,description,expiryDate) VALUES(?,?,?,?)";
		
		Object object[] = {medicine.getMedicineName(),medicine.getQuantity(),medicine.getDescription(),medicine.getExpiryDate()};
		
		jdbcTemplate.update(sql,object);
	}

	@Override
	public UserLoginDto getUserDetails(String email) {
		
		String sql = "select * from users where email = ? ";
		
		try {
				
		UserLoginDto userLoginDto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UserLoginDto>(UserLoginDto.class),email);
		
		return userLoginDto;
		
		}
		catch(EmptyResultDataAccessException e) {
			
			return null;
		}
		
	}
	
	@Override
	public boolean getStudentId(String rollNo) {
		
		String sql = "select rollNo from Students where rollNo = ? ";
		
		try {
		
			UserIdDto userIdDto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UserIdDto>(UserIdDto.class),rollNo);
			return userIdDto!=null;
		}
		catch(EmptyResultDataAccessException e) {
			
			return false;
			
		}
		
	}
	
	@Override
	public boolean getFacultyId(String id) {
		
		String sql = "select id from faculty where id = ? ";
		
		try {
		
			UserIdDto userIdDto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UserIdDto>(UserIdDto.class),id);
			return userIdDto!=null;
		}
		catch(EmptyResultDataAccessException e) {
			
			return false;
			
		}
		
	}
	
	@Override
	public boolean getStaffId(String id) {
		
		String sql = "select id from NonTeachingStaff where id = ? ";
		
		try {
		
			UserIdDto userIdDto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UserIdDto>(UserIdDto.class),id);
			return userIdDto!=null;
		}
		catch(EmptyResultDataAccessException e) {
			
			return false;
			
		}
		
	}

	@Override
	public List<StudentIssueDto> getAllIssues() {
		
		String sql = "select s.rollNo,s.studentName,s.department,i.description,i.medicines,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo";
		
		List<StudentIssueDto> studentIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class));
		
		return studentIssueDto;
	}
	
	@Override
	public List<FacultyIssueDto> getAllFacultyIssues() {
		
		String sql = "select f.id,f.facultyName,f.department,i.description,i.medicines,i.createdAt from FacultyIssues i INNER JOIN faculty f on i.faculty_id = f.id";
		
		List<FacultyIssueDto> FacultyIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<FacultyIssueDto>(FacultyIssueDto.class));
		
		return FacultyIssueDto;
	}
	
	@Override
	public List<NonTeachingStaffDto> getAllStaffIssues() {
		
		String sql = "select f.id,f.facultyName,f.department,i.description,i.medicines,i.createdAt from NonTeachingStaffIssues i INNER JOIN NonTeachingStaff f on i.faculty_id = f.id";
		
		List<NonTeachingStaffDto> nonteachingStaffDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<NonTeachingStaffDto>(NonTeachingStaffDto.class));
		
		return nonteachingStaffDto;
	}
	
	@Override
	public List<StudentIssueDto> getMaleIssues() {
		
		String sql = "select s.rollNo,s.studentName,s.department,i.description,i.medicines,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where s.gender = ?";
		
		List<StudentIssueDto> userIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class),"male");
		
		return userIssueDto;
	}
	
	@Override
	public List<FacultyIssueDto> getFacultyMaleIssues() {
		
		String sql = "select f.id,f.facultyName,f.department,i.description,i.medicines,i.createdAt from FacultyIssues i INNER JOIN faculty f on i.faculty_id = f.id where f.gender = ?";
		
		List<FacultyIssueDto> facultyIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<FacultyIssueDto>(FacultyIssueDto.class),"male");
		
		return facultyIssueDto;
	}
	
	@Override
	public List<NonTeachingStaffDto> getNonteachingMaleIssues() {
		
		String sql = "select f.id,f.facultyName,f.department,i.description,i.medicines,i.createdAt from NonTeachingStaffIssues i INNER JOIN NonTeachingStaff f on i.faculty_id = f.id where f.gender = ?";
		
		List<NonTeachingStaffDto> nonteachingStaffDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<NonTeachingStaffDto>(NonTeachingStaffDto.class),"male");
		
		return nonteachingStaffDto;
	}
	
	@Override
	public List<StudentIssueDto> getFemaleIssues() {
		
		String sql = "select s.rollNo,s.studentName,s.department,i.description,i.medicines,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where s.gender = ?";
		
		List<StudentIssueDto> userIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class),"female");
		
		return userIssueDto;
	}
	
	@Override
	public List<FacultyIssueDto> getFacultyFemaleIssues() {
		
		String sql = "select f.id,f.facultyName,f.department,i.description,i.medicines,i.createdAt from FacultyIssues i INNER JOIN faculty f on i.faculty_id = f.id where f.gender = ?";
		
		List<FacultyIssueDto> facultyIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<FacultyIssueDto>(FacultyIssueDto.class),"female");
		
		return facultyIssueDto;
	}
	
	@Override
	public List<NonTeachingStaffDto> getNonTeachingFemaleIssues() {
		
		String sql = "select f.id,f.facultyName,f.department,i.description,i.medicines,i.createdAt from NonTeachingStaffIssues i INNER JOIN NonTeachingStaff f on i.faculty_id = f.id where f.gender = ?";
		
		List<NonTeachingStaffDto> nonteachingStaffDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<NonTeachingStaffDto>(NonTeachingStaffDto.class),"female");
		
		return nonteachingStaffDto;
	}

	@Override
	public int getCount() {
		
		int count=0;
		
		String sql;
		
		sql = "select count(i.rollNo) from Issues i INNER JOIN Students s on i.rollNo = s.rollNo";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class);
		
		sql = "select count(i.faculty_id) from FacultyIssues i INNER JOIN  faculty f on i.faculty_id = f.id";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class);
		
		sql = "select count(i.faculty_id) from NonTeachingStaffIssues i INNER JOIN  NonTeachingStaff f on i.faculty_id = f.id";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class);
		
		return count;
	}
	@Override
	public int getMaleCount() {
		
		int count = 0;
		
		String sql;
		
		sql = "select count(i.rollNo) from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where gender = ?";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class,"male");
		
		sql = "select count(i.faculty_id) from FacultyIssues i INNER JOIN  faculty f on i.faculty_id = f.id where gender = ?";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class,"male");
		
		sql = "select count(i.faculty_id) from NonTeachingStaffIssues i INNER JOIN  NonTeachingStaff f on i.faculty_id = f.id where gender = ?";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class,"male");
		
		return count;
	}
	
	@Override
	public int getFemaleCount() {
		
		int count = 0;
		
		String sql;
		
		sql = "select count(i.rollNo) from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where gender = ?";
		
		count = jdbcTemplate.queryForObject(sql,Integer.class,"female");
		
		sql = "select count(i.faculty_id) from FacultyIssues i INNER JOIN  faculty f on i.faculty_id = f.id where gender = ?";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class,"female");
		
		sql = "select count(i.faculty_id) from NonTeachingStaffIssues i INNER JOIN  NonTeachingStaff f on i.faculty_id = f.id where gender = ?";
		
		count = count + jdbcTemplate.queryForObject(sql,Integer.class,"female");
		
		return count;
	}

	@Override
	public List<MedicineDto> getMedicines() {
		
		String sql = "select * from Medicines";
		
		List<MedicineDto> medcines = jdbcTemplate.query(sql,new BeanPropertyRowMapper<MedicineDto>(MedicineDto.class));
		
		return medcines;
		
	}
	
	@Override
	public boolean updatePassword(ForgotPasswordDto user) {
		
		String sql = "update users set passWord = ? where email = ?";
		
		int rowCount = jdbcTemplate.update(sql,user.getPassword(),user.getEmail());
		
		if(rowCount==0)
			return false;
		
		return true;
	}

	@Override
	public boolean updateQuantity(MedicineUpdateDto medicine) {
		
		String sql = "update Medicines set quantity = ? where id = ?";
		
		int rowsAffected = jdbcTemplate.update(sql,medicine.getQuantity(),medicine.getId());
		
		if(rowsAffected==0)
		{	
			return false;
		}
		
		return true;
	}
	
	public boolean changePassword(UpdatePasswordDto userEnteredInfo) {
		
		UserLoginDto userLoginDto = getUserDetails(userEnteredInfo.getEmail());
		
		if(!validation.validateChangePassword(userEnteredInfo,userLoginDto))
		{
			return false;
		}
		
		if(!setNewPassword(userEnteredInfo))
		{
			return false;
		}
		
		return true;
		
	}
	
	@Override
	public boolean setNewPassword(UpdatePasswordDto user) {
		
		String sql = "update users set passWord = ? where email = ?";
		
		int rowCount = jdbcTemplate.update(sql,user.getNewPassword(),user.getEmail());
		
		if(rowCount==0)
			return false;
		
		return true;
	}
	

	
	@Override
	public MedicineDto getMedicine(String medicine) {
		
		String sql="select * from Medicines where MedicineName = ?";
		
		MedicineDto Medicine = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<MedicineDto>(MedicineDto.class),medicine);
		
		return Medicine;
	}
	
	@Override
	public void medicineUpdateQuantity(MedicineDto medicine) {
		
		System.out.println(medicine.getQuantity() + "******************");
		
		String sql = "update Medicines set quantity = ? where id = ?";
		
		jdbcTemplate.update(sql,medicine.getQuantity(),medicine.getId());
	}
	
	@Override
	public boolean deleteMedicine(int id) {
		
		String sql="delete from Medicines where id = ? ";
		
		int rowCount = jdbcTemplate.update(sql,id);
		
		if(rowCount==0)
			return false;
		
		return true;
	}
	
	public List<MedicineDto> getAllMedicines() {
		
		String sql = "select * from Medicines";
		
		List<MedicineDto> medicines  = jdbcTemplate.query(sql,new BeanPropertyRowMapper<MedicineDto>(MedicineDto.class));
		
		return medicines;
		
	}
	
	public List<StudentIssueDto> getStudentIssues(String id)
	{
		String sql = "select s.studentName,s.rollNo,s.department,i.description,i.medicines,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where i.rollNo = ?";
		
		List<StudentIssueDto> student = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class),id);
		
		return student;
	}
	

	public List<FacultyIssueDto> getFacultyIssues(String id)
	{
		String sql = "select f.facultyName,f.id,f.department,i.description,i.medicines,i.createdAt from FacultyIssues i INNER JOIN faculty f on i.faculty_id = f.id where i.faculty_id = ?";
		
		List<FacultyIssueDto> faculty = jdbcTemplate.query(sql,new BeanPropertyRowMapper<FacultyIssueDto>(FacultyIssueDto.class),id);
		
		return faculty;
	}
	

	public List<NonTeachingStaffDto> getStaffIssues(String id)
	{
		String sql = "select s.facultyName,s.id,s.department,i.description,i.medicines,i.createdAt from NonTeachingStaffIssues i INNER JOIN NonTeachingStaff s on i.faculty_id = s.id where i.faculty_id = ?";
		
		List<NonTeachingStaffDto> staff = jdbcTemplate.query(sql,new BeanPropertyRowMapper<NonTeachingStaffDto>(NonTeachingStaffDto.class),id);
		
		return staff;
	}
	
	@Override
	public UserDto getUserDetailsByEmail(String email) {
		
		String sql = "select * from users where email = ? ";
		
		try {
				
			UserDto userDto = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<UserDto>(UserDto.class),email);
		
		return userDto;
		
		}
		catch(EmptyResultDataAccessException e) {
			
			return null;
		}
		
	}
	
	public void setLastLogin(String email)
	{
		String sql = "update users set lastLogin = CURRENT_TIMESTAMP where email = ?";
		
		jdbcTemplate.update(sql,email);
	}
	
	public DriverManagerDataSource getDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
    dataSource.setUsername(System.getenv("SPRING_DATASOURCE_USERNAME"));
    dataSource.setPassword(System.getenv("SPRING_DATASOURCE_PASSWORD"));
    return dataSource;
}

	

}
