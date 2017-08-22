package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

//DQL(select), DML
public class EmpDAO {
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	int count;

	public List<EmpDTO> selectAll() {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		conn = DBUtil.getConnect();
		String sql = "select * from emp";
		try {
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				EmpDTO e = makeEmp(rs);
				emplist.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}

		return emplist;
	}

	private EmpDTO makeEmp(ResultSet rs) throws SQLException {
		EmpDTO emp = new EmpDTO();
		emp.setComm(rs.getDouble("comm"));
		emp.setDeptno(rs.getInt("deptno"));
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setHiredate(rs.getDate("hiredate"));
		emp.setJob(rs.getString("job"));
		emp.setMgr(rs.getInt("mgr"));
		emp.setSal(rs.getDouble("sal"));
		return emp;
	}

	public EmpDTO selectById(int empid) {
		EmpDTO emp = null;
		conn = DBUtil.getConnect();
		String sql = "select * from emp where empno= ? ";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, empid);
			rs = st.executeQuery();
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return emp;
	}

	public List<EmpDTO> selectByCondition(int deptno, String job, double sal) {
		List<EmpDTO> emplist = new ArrayList<EmpDTO>();
		conn = DBUtil.getConnect();
		String sql = "select * from emp " + "where deptno=? and job=? and sal>=?";
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptno);
			st.setString(2, job);
			st.setDouble(3, sal);
			rs = st.executeQuery();
			while (rs.next()) {
				EmpDTO e = makeEmp(rs);
				emplist.add(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return emplist;
	}

	public int[] empManyInserts(EmpDTO[] emps){
		int[] result = null;
		conn = DBUtil.getConnect();
		String sql = " insert into emp(empno,  ename, " 
		+ " job,  mgr,  hiredate,  sal,  comm,  deptno) "
				+ " values  ";
	
		try {
			Statement st2 = conn.createStatement();
           for(EmpDTO emp : emps){
        	   
        	   String sql2 =  "("
        	   		+ emp.getEmpno()
        	   		+ ",'"
        	   		+ emp.getEname()
        	   		+ "','"
        	   		+ emp.getJob()
        	   		+ "',"
        	   		+ emp.getMgr()
        	   		+ ",'"
        	   		+ emp.getHiredate()
        	   		+ "',"
        	   		+ emp.getSal()
        	   		+ ","
        	   		+ emp.getComm()
        	   		+ ","
        	   		+ emp.getDeptno()
        	   		+ " )";
        	   
				st2.addBatch(sql + sql2);
           }
			
			result=st2.executeBatch();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	
	public int empInsert(EmpDTO emp) {
		conn = DBUtil.getConnect();

		String sql = " insert into emp(empno,  ename, " + " job,  mgr,  hiredate,  sal,  comm,  deptno) "
				+ " values (?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql);
			st.setInt(1, emp.getEmpno());
			st.setString(2, emp.getEname());
			st.setString(3, emp.getJob());
			st.setInt(4, emp.getMgr());
			st.setDate(5, emp.getHiredate());
			st.setDouble(6, emp.getSal());
			st.setDouble(7, emp.getComm());
			st.setInt(8, emp.getDeptno());
			count = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	public int empUpdate(EmpDTO emp) {
		conn = DBUtil.getConnect();

		String sql = " update emp"
				+ " set  ename=?, job=?,  mgr=?,  "
				+ "hiredate=?,  sal=?,  comm=?,  deptno=? "
				+ " where empno=? ";
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql);
			st.setInt(8, emp.getEmpno());
			st.setString(1, emp.getEname());
			st.setString(2, emp.getJob());
			st.setInt(3, emp.getMgr());
			st.setDate(4 ,emp.getHiredate());
			st.setDouble(5, emp.getSal());
			st.setDouble(6, emp.getComm());
			st.setInt(7, emp.getDeptno());
			count = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}

	public int empDelete(int empno) {
		conn = DBUtil.getConnect();

		String sql = " delete from emp"
				+ " where empno=? ";
		try {
			conn.setAutoCommit(false);
			st = conn.prepareStatement(sql);
			st.setInt(1, empno);
			count = st.executeUpdate();//DML수행(insert/update/delete)
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DBUtil.dbClose(conn, st, rs);
		}
		return count;
	}
	
	public void sqlExeute(String sql){
		 conn = DBUtil.getConnect();
		 try {
			st = conn.prepareStatement(sql);
			boolean b = st.execute();
			if(b){
				//select문
				rs = st.getResultSet();
				while(rs.next()){
					String s = rs.getString(1);
					System.out.println(s);
				}
			}else{
				//DML문 
				count = st.getUpdateCount();
				System.out.println(count+"건이 영향을 받음");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
}








