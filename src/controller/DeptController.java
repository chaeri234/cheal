package controller;

import java.util.List;

import model.DeptDAO;
import model.DeptDTO;
import view.DeptView;


public class DeptController {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		
		//모든부서 정보 조회
		List<DeptDTO> deptlist = dao.selectDeptAll();
		DeptView.print(deptlist);
		
		//특정부서 정보 조회
		DeptDTO dept = dao.selectDeptbyId(10);
		DeptView.print(dept);
		
		//문자
		DeptView.print("JDBC재밋어~~~");
		

	}

}
