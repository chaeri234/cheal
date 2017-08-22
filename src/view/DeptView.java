package view;

import java.util.List;

import model.DeptDTO;


public class DeptView {

	public static void print( List<DeptDTO> deptlist){
		System.out.println("★★★여러건★★★★★★★");
		
		for(DeptDTO dept : deptlist){
			System.out.println(dept);
		}
		
	}
	
	public static void print( DeptDTO dept){
		System.out.println("♥♥♥♥한건♥♥♥♥♥♥");
	    System.out.println(dept);	 
	}
	
	public static void print( String msg){
		System.out.println("알림:" + msg);
	   
	}
	
}




