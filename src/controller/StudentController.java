package controller;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.StudentDAO;
import model.StudentDTO;
import view.StudentView;


public class StudentController {

	public static void main(String[] args) throws IOException {
		System.out.println("1.모두조회");
		System.out.println("2.특정학생조회");
		System.out.println("3.학생입력");
		System.out.println("0.빠지기");
		
		StudentDAO dao = new StudentDAO();
		List<StudentDTO> slist = null;
		StudentDTO st = null;
			
		Scanner sc = new Scanner(System.in);
		myloop:while(true){
			System.out.print("작업선택>>");
			int select = sc.nextInt();
			switch(select){
			case 0:
				System.out.println("퇴근합니다.");
				break  myloop;
			case 1:
				slist = dao.selectAll();
				StudentView.print(slist);
				break;
			case 2:
				System.out.print("학생번호>>");
				String id = sc.next();
				st = dao.selectById(id);
				StudentView.print(st);
				break;
			case 3:
				System.out.print("학생번호>>");
				String std_id = sc.next();
				System.out.print("학생이름>>");
				String name = sc.next();
				System.out.print("학생이메일>>");
				String email = sc.next();
				System.out.print("학생전공 1,2,3,4>>");
				int major_id = sc.nextInt();
				System.out.print("학생전번>>");
				String phone = sc.next();
				System.out.print("학생성별 M,F>>");
				char gender = sc.next().charAt(0);
				System.out.print("학생등록금>>");
				int tuition_fee = sc.nextInt();
				
				st = new StudentDTO(std_id, name, email, phone, gender, tuition_fee, major_id);
				int result = dao.studentInsert(st);
				String msg="입력에 실패";
				if(result>0) msg="입력에 성공";
				StudentView.print(msg);	
				break;
			default:
				
			}
		}

	}

}





