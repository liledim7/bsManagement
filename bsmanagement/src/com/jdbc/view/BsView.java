package com.jdbc.view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.jdbc.controller.BsController;
import com.jdbc.model.dto.Department;
import com.jdbc.model.dto.Employee;
import com.jdbc.model.dto.Job;

public class BsView {
	BsController bc=new BsController();

	public void MainMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== 사원 관리 =====");
			System.out.println("1. 전체 사원조회");
			System.out.println("2. 사원조회 메뉴");
			System.out.println("3. 사원등록");
			System.out.println("4. 사원 수정(직책, 부서, 급여, 전화번호, 이메일)");
			System.out.println("5. 사원 삭제");
			System.out.println("6. 부서관리 메뉴");
			System.out.println("7. 직책관리 메뉴");
			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴 입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1 : bc.selectEmpAll();break;
				case 2 : bc.selectEmpMenu();break;
				case 3 : bc.insertEmp();break;
				case 4 : bc.updateEmp();break;
				case 5 : bc.deleteEmp();break;
				case 6 : bc.deptMenu();break;
				case 7 : bc.jobMenu();break;
				case 0 : System.out.println("프로그램을 종료합니다.");return;
				default : System.out.println("0~7사이의 메뉴를 입력해주세요");
			}
		}
	}
	
	public void empMenu() {
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("1. 부서로 조회");
			System.out.println("2. 직책으로 조회");
			System.out.println("3. 이름으로 조회");
			System.out.println("4. 급여로 조회(U/D)");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("메뉴 입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1:bc.selectEmpdept();break;
				case 2:bc.selectEmpJob();break;
				case 3:bc.selectEmpName();break;
				case 4:bc.selectEmpSalary();break;
				default : System.out.println("메인으로 돌아갑니다.");return;
			}
			
		}
	}
	
	public Employee insertEmp() {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		SimpleDateFormat f = new SimpleDateFormat();
		System.out.print("empId: ");
		e.setEmpId(sc.next());
		System.out.print("empName: ");
		e.setEmpName(sc.next());
		System.out.print("empNo: ");
		e.setEmpNo(sc.next());
		System.out.print("email: ");
		e.setEmail(sc.next());
		System.out.print("phone: ");
		e.setPhone(sc.next());
		System.out.print("deptCode: ");
		e.setDeptCode(sc.next().toUpperCase());
		System.out.print("jobCode: ");
		e.setJobCode(sc.next().toUpperCase());
		System.out.print("salLevel: ");
		e.setSalLevel(sc.next().toUpperCase());
		System.out.print("salary: ");
		e.setSalary(sc.nextInt());
		System.out.print("bonus: ");
		e.setBonus(sc.nextDouble());
		System.out.print("managerId: ");
		e.setManagerId(sc.next());
		sc.nextLine();
		System.out.print("hireDate(yyyy-mm-dd): ");
		
		e.setHireDate(Date.valueOf(sc.nextLine()));
		System.out.print("entYn: ");
		e.setEntYn(sc.next());
		return e;
	}
	
	public Employee updateEmp() {
		Scanner sc=new Scanner(System.in);
		Employee e=new Employee();
		System.out.print("새 직책: ");
		e.setJobCode(sc.next().toUpperCase());
		System.out.print("새 부서: ");
		e.setDeptCode(sc.next().toUpperCase());
		System.out.print("새 급여: ");
		e.setSalary(sc.nextInt());
		System.out.print("새 전화번호: ");
		e.setPhone(sc.next());
		System.out.print("새 이메일: ");
		e.setEmail(sc.next());
		return e;
	}
	
	public void deptMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== 부서관리 ====" );
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("메뉴 입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1:bc.insertDept();break;
				case 2:bc.updateDept();break;
				case 3:bc.deleteDept();break;
				default :System.out.println("메인으로 돌아갑니다.");return;
			}
		}
	}
	
	public Department insertDept() {
		Scanner sc=new Scanner(System.in);
		Department d=new Department();
		System.out.print("부서아이디: ");
		d.setDeptId(sc.nextLine().toUpperCase());
		System.out.print("부서이름: ");
		d.setDeptTitle(sc.nextLine());
		System.out.print("지역이름: ");
		d.setLocationId(sc.nextLine().toUpperCase());
		return d;
	}
	
	public Department updateDept() {
		Scanner sc=new Scanner(System.in);
		Department d=new Department();
		System.out.print("새 부서 이름: ");
		d.setDeptTitle(sc.nextLine());
		System.out.print("새 지역 아이디: ");
		d.setLocationId(sc.nextLine().toUpperCase());
		return d;
	}
	
	public void jobMenu() {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("==== 직책관리 ====" );
			System.out.println("1. 등록");
			System.out.println("2. 수정");
			System.out.println("3. 삭제");
			System.out.println("0. 메인으로 돌아가기");
			System.out.print("메뉴 입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1:bc.insertJob();break;
				case 2:bc.updateJob();break;
				case 3:bc.deleteJob();break;
				default :System.out.println("메인으로 돌아갑니다.");return;
			}
		}
	}
	
	public Job insertJob() {
		Scanner sc=new Scanner(System.in);
		Job j=new Job();
		System.out.print("직책코드: ");
		j.setJobCode(sc.nextLine().toUpperCase());
		System.out.print("직책이름: ");
		j.setJobName(sc.nextLine());
		return j;
	}
	
	public String updateJob() {
		Scanner sc=new Scanner(System.in);
		System.out.print("새 직책명: ");
		return sc.nextLine();
	}
	
	public void printMsg(String msg) {
		System.out.println(msg);
	}
	
	
	public int inputData() {
		Scanner sc=new Scanner(System.in);
		System.out.print("급여 입력: ");
		return sc.nextInt();
	}
	
	public String inputData(String title) {
		Scanner sc=new Scanner(System.in);
		System.out.print(title+"입력: ");
		return sc.nextLine();
	}
	public void printEmp(List<Employee>emp) {
		System.out.println("==== 사원 ====");
		emp.forEach(e->System.out.println(e));
	}
}













