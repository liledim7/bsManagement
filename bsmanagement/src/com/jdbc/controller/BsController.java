package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.common.Controller;
import com.jdbc.model.dto.Employee;
import com.jdbc.service.BsService;
import com.jdbc.view.BsView;

public class BsController implements Controller{

	
	private BsService service=new BsService();
	public void MainMenu() {
		new BsView().MainMenu();
	}

	@Override
	public void selectEmpAll() {
		List<Employee> emp=service.selectEmpAll();
		new BsView().printEmp(emp);
	}

	@Override
	public void selectEmpMenu() {
		new BsView().empMenu();
		
	}

	@Override
	public void selectEmpdept() {
		String dept=new BsView().inputData("부서");
		List<Employee> emp=service.selectEmpDept(dept);
		new BsView().printEmp(emp);
		
	}

	@Override
	public void selectEmpJob() {
		String job=new BsView().inputData("직책");
		List<Employee> emp=service.selectEmpJob(job);
		new BsView().printEmp(emp);
		
	}

	@Override
	public void selectEmpName() {
		String name=new BsView().inputData("이름");
		List<Employee> emp=service.selectEmpName(name);
		new BsView().printEmp(emp);
		
	}

	@Override
	public void selectEmpSalary() {
		List<Employee> emp=new ArrayList<>();
		String ou=new BsView().inputData("급여비교(u/d)");
		int sal=0;
		if(ou.toLowerCase().equals("u")) {
			sal=new BsView().inputData();
			emp=service.selectEmpSalaryOver(sal);
		}
		else if(ou.toLowerCase().equals("d")){
			sal=new BsView().inputData();
			emp=service.selectEmpSalaryUnder(sal);
		}else System.out.println("잘못 입력하였습니다");
		new BsView().printEmp(emp);
		
	}

	@Override
	public void insertEmp() {
		Employee e=new BsView().insertEmp();
		int result=service.insertEmp(e);
		System.out.println(result>0?"저장성공":"저장실패");
	}

	@Override
	public void updateEmp() {
		String id=new BsView().inputData("변경할 사원 아이디");
		Employee e=new BsView().updateEmp();
		int result=service.updateEmp(id, e);
		System.out.println(result>0?"수정성공":"수정실패");
		
	}

	@Override
	public void deleteEmp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deptMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jobMenu() {
		// TODO Auto-generated method stub
		
	}
	
	
}
