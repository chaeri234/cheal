package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

//Business Logic 
//Data Access Object
public class DeptDAO {
    Connection conn;
    PreparedStatement st;
    ResultSet rs;
	
	public List<DeptDTO> selectDeptAll() {
		List<DeptDTO> deptlist = new ArrayList<DeptDTO>();
        conn = DBUtil.getConnect();
        String sql = "select * from departments";       
        try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()){
				DeptDTO dept = makeDept(rs);
				deptlist.add(dept);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}        
		return deptlist;
	}
	private DeptDTO makeDept(ResultSet rs) throws SQLException {
		int department_id = rs.getInt(1);
		String department_name = rs.getString(2);
		int manager_id = rs.getInt(3);
		int location_id = rs.getInt(4);
		DeptDTO dept = new DeptDTO(department_id,
				department_name, manager_id, location_id);
	    return dept;
	}

	public DeptDTO selectDeptbyId(int id) {
		DeptDTO dept = null;
        conn = DBUtil.getConnect();
        String sql = "select * from departments "
        		+ "where department_id = ?";       
        try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rs = st.executeQuery();
			while(rs.next()){
				dept = makeDept(rs);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}        
		return dept;
	}

}
