package controller;

import java.sql.Date;

import model.EmpDAO;
import model.EmpDTO;
import util.DateUtil;

public class EmpController {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		
		String sdate = "2017/08/10";
		Date hiredate = DateUtil.stringToDate(sdate);
		
		//입력여러건 
		EmpDTO[] arr = new  EmpDTO[3] ;
		arr[0] = new EmpDTO(33, "이서진", "MANAGER",
				1, hiredate, 5000, 2.1, 10);
		arr[1] = new EmpDTO(34, "박지원", "MANAGER",
				1, hiredate, 5000, 2.1, 20);
		arr[2] = new EmpDTO(35, "이건호", "MANAGER",
				1, hiredate, 5000, 2.1, 30);
		int[] results = dao.empManyInserts(arr);
		for(int i : results){
			System.out.println(i);
		}
		
		
		
		
		
		//한건 조회
		//EmpView.show(dao.selectById(7566));		
		
		//입력
		/*String sdate = "2017/08/10";
		Date hiredate = DateUtil.stringToDate(sdate);
		EmpDTO emp = new EmpDTO(
				2, "정진2", "MANAGER", 7566, hiredate, 
				1000.00, 1.2, 20);
		int ret = dao.empInsert(emp);
		EmpView.show(ret>0?"입력성공":"입력실패"); */		
		//수정
		/*String sdate = "2016/09/10";
		Date hiredate = DateUtil.stringToDate(sdate);
		EmpDTO emp = new EmpDTO(
				2, "진수정", "CLERK", 1, hiredate, 
				2000.00, 1.5, 10);
		int ret = dao.empUpdate(emp);
		EmpView.show(ret>0?"Update성공":"Update실패"); 		*/
		//삭제
		//int ret = dao.empDelete(2);
		//EmpView.show(ret>0?"Delete성공":"Delete실패");		
		//모두조회
	    //EmpView.show(dao.selectAll());
		
	    

	}

}




