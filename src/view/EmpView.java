package view;

import java.util.List;

import model.EmpDTO;

public class EmpView {

	public static void show(List<EmpDTO> emplist) {
		if (emplist.size() == 0) {
			System.out.println("조회된 데이타 없음");
			return;
		}
		System.out.println("====여러건의 emp정보=======");
		for (EmpDTO e : emplist) {
			System.out.println(e);
		}
	}

	public static void show(EmpDTO emp) {
		System.out.println("==== emp정보=======");
		System.out.println(emp);
	}
	
	public static void show(String empmsg) {
		System.out.println("==== 알림니다.=======");
		System.out.println(empmsg);
	}
	
	

}
