package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

//Select, DML(insert,delete,update)
public class StudentDAO {
     Connection conn;
     PreparedStatement st;
     ResultSet rs;
     int count;
   
   //입력
  	public int studentInsert(StudentDTO dto){
  		String sql="insert into students values (?,?,?,?,?,?,?)";  
  		
  		conn = DBUtil.getConnect();
  		try {
  			st = conn.prepareStatement(sql);
  			st.setString(1, dto.getStd_id());
  			st.setString(2, dto.getName());
  			st.setString(3, dto.getEmail());
  			st.setString(4, dto.getPhone());
  			st.setString(5, dto.getGender()+"");
  			st.setInt(6, dto.getTuition_fee());
  			st.setInt(7, dto.getMajor_id());
     		
  			count = st.executeUpdate();
  			
  			
  		} catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} finally {
  			DBUtil.dbClose(conn, st, rs);
  		}
  		return count;
  		
  	}
     
     
     
     
 	//한껀조회
 	public StudentDTO selectById(String id){
 		 
 		StudentDTO dto=null;
 		String sql="select * from students where trim(std_id) = ? ";
 		conn = DBUtil.getConnect();
 		try {
 			st = conn.prepareStatement(sql);
 			st.setString(1, id);
 			rs = st.executeQuery();
 			while(rs.next()){
 				dto = makeStudent(rs ); 			 
 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} finally {
 			DBUtil.dbClose(conn, st, rs);
 		}
 		return dto;
 		
 	}
     
     
     
     
     
     
	//모든조회
	public List<StudentDTO> selectAll(){
		List<StudentDTO> slist = new ArrayList<>();
		String sql="select * from students";
		conn = DBUtil.getConnect();
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				StudentDTO dto = makeStudent(rs );
				slist.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return slist;		
	}

	private StudentDTO makeStudent(ResultSet rs) throws SQLException {
		String std_id = rs.getString(1);
		String name = rs.getString(2);
		String email = rs.getString(3);
		String phone = rs.getString(4);
		char gender = rs.getString(5).charAt(0);
		int tuition_fee = rs.getInt(6);
		int major_id = rs.getInt(7);
		return new StudentDTO(std_id, name, email, phone,
				gender, tuition_fee, major_id);
	}
}








