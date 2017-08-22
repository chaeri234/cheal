package view;

import java.util.List;

import model.StudentDTO;

public class StudentView {

	public static void print( List<StudentDTO> list){
		System.out.println("★★★여러건 학생정보★★★★★★★");		
		for(StudentDTO st : list){
			System.out.println(st);
		}
		
	}
	
	public static void print( StudentDTO st){
		System.out.println("♥♥♥♥한건 학생정보♥♥♥♥♥♥");
	    System.out.println(st);	 
	}
	
	public static void print( String msg){
		System.out.println("알림:" + msg);
	   
	}
	
}




