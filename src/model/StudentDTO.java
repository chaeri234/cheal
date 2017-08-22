package model;

//Spring, Mybatis framework 사용
//JavaBeans규격서...멤버변수private, default생성자,getter/setter  
public class StudentDTO {
	 private String std_id;
	 private String name;
	 private String email;
	 private String phone;
	 private char gender;
	 private  int tuition_fee;
	 private  int major_id;

	 
	

	 
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StudentDTO [std_id=").append(std_id).append(", name=").append(name).append(", email=")
				.append(email).append(", phone=").append(phone).append(", gender=").append(gender)
				.append(", tuition_fee=").append(tuition_fee).append(", major_id=").append(major_id).append("]");
		return builder.toString();
	}

	public StudentDTO(){
		 
	 }
	 
	 public StudentDTO(String std_id, String name, String email, String phone, char gender, int tuition_fee,
			int major_id) {
		super();
		this.std_id = std_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.tuition_fee = tuition_fee;
		this.major_id = major_id;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getTuition_fee() {
		return tuition_fee;
	}
	public void setTuition_fee(int tuition_fee) {
		this.tuition_fee = tuition_fee;
	}
	public int getMajor_id() {
		return major_id;
	}
	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}
	 
	 
}
