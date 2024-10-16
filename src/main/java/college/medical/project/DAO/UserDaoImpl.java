package college.medical.project.DAO;



import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import college.medical.project.DTO.ForgotPasswordDto;
import college.medical.project.DTO.MedicineDto;
import college.medical.project.DTO.MedicineUpdateDto;
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
		
		
		String sql = "INSERT INTO users(id,email,userName,passWord) VALUES(?,?,?,?)";
		
		Object object[] = {user.getId(),user.getEmail(),user.getUserName(),user.getPassWord()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertStudent(StudentIssueDto student) {
		
		String sql = "INSERT INTO Students(rollNo,studentName,department,gender) VALUES(?,?,?,?)";
		
		Object object[] = {student.getRollNo(),student.getStudentName(),student.getDepartment(),student.getGender().toLowerCase()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertIssue(StudentIssueDto student) {
		
		RandomId random = new RandomId();
		
		String id = random.generateUuid();
		
		String sql = "INSERT INTO Issues(id,rollNo,description,medicine) VALUES(?,?,?,?)";
		
		System.out.println(id+" --------------------------------------");
		
		Object object[] = {id,student.getRollNo(),student.getDescription(),student.getMedicine()};
		
		jdbcTemplate.update(sql,object);
	}
	
	@Override
	public void insertMedicine(MedicineDto medicine) {
		
		String sql = "INSERT INTO Medicines(MedicineName,quantity,description) VALUES(?,?,?)";
		
		Object object[] = {medicine.getMedicineName(),medicine.getQuantity(),medicine.getDescription()};
		
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
	public List<StudentIssueDto> getAllIssues() {
		
		String sql = "select s.rollNo,s.studentName,s.department,i.description,i.medicine,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo";
		
		List<StudentIssueDto> studentIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class));
		
		return studentIssueDto;
	}
	
	@Override
	public List<StudentIssueDto> getMaleIssues() {
		
		String sql = "select s.rollNo,s.studentName,s.department,i.description,i.medicine,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where s.gender = ?";
		
		List<StudentIssueDto> userIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class),"male");
		
		return userIssueDto;
	}
	
	@Override
	public List<StudentIssueDto> getFemaleIssues() {
		
		String sql = "select s.rollNo,s.studentName,s.department,i.description,i.medicine,i.createdAt from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where s.gender = ?";
		
		List<StudentIssueDto> userIssueDto = jdbcTemplate.query(sql,new BeanPropertyRowMapper<StudentIssueDto>(StudentIssueDto.class),"female");
		
		return userIssueDto;
	}

	@Override
	public int getCount() {
		
		String sql = "select count(i.rollNo) from Issues i INNER JOIN Students s on i.rollNo = s.rollNo";
		
		int count = jdbcTemplate.queryForObject(sql,Integer.class);
		
		return count;
	}
	@Override
	public int getMaleCount() {
		
		String sql = "select count(i.rollNo) from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where gender = ?";
		
		int count = jdbcTemplate.queryForObject(sql,Integer.class,"male");
		
		return count;
	}
	
	@Override
	public int getFemaleCount() {
		
		
		String sql = "select count(i.rollNo) from Issues i INNER JOIN Students s on i.rollNo = s.rollNo where gender = ?";
		
		int count = jdbcTemplate.queryForObject(sql,Integer.class,"female");
		
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
	
//	public DriverManagerDataSource getDataSource() {
//	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//	    dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
//	    dataSource.setUsername(System.getenv("SPRING_DATASOURCE_USERNAME"));
//	    dataSource.setPassword(System.getenv("SPRING_DATASOURCE_PASSWORD"));
//	    return dataSource;
//	}
	
	public DriverManagerDataSource getDataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/servicebooking?useSSL=false");
	    dataSource.setUsername("root");
	    dataSource.setPassword("Srinu379@");
	    return dataSource;
	}

}
