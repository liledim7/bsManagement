package com.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.common.Controller;
import com.jdbc.model.dto.Department;
import com.jdbc.model.dto.Employee;
import com.jdbc.model.dto.Job;
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
		}else new BsView().printMsg("잘못 입력하였습니다");  
		new BsView().printEmp(emp);
		
	}

	@Override
	public void insertEmp() {
		Employee e=new BsView().insertEmp();
		int result=service.insertEmp(e);
		new BsView().printMsg(result>0?"저장성공":"저장실패");
	}

	@Override
	public void updateEmp() {
		String id=new BsView().inputData("변경할 사원아이디");
		Employee e=new BsView().updateEmp();
		int result=service.updateEmp(id, e);
		new BsView().printMsg(result>0?"수정성공":"수정실패");
		
	}

	@Override
	public void deleteEmp() {
		String id=new BsView().inputData("삭제할 사원아이디 ");
		int result=service.deleteEmp(id);
		new BsView().printMsg(result>0?"삭제성공":"삭제실패");
	}

	@Override
	public void deptMenu() {
		new BsView().deptMenu();
		
	}

	@Override
	public void insertDept() {
		Department d=new BsView().insertDept();
		int result=service.insertDept(d);
		new BsView().printMsg(result>0?"부서등록성공":"부서등록실패");
		
		
	}

	@Override
	public void updateDept() {
		String id=new BsView().inputData("수정할 부서아이디 ").toUpperCase();
		Department d=new BsView().updateDept();
		int result=service.updateDept(id,d);
		new BsView().printMsg(result>0?"부서수정성공":"부서수정실패");
	}

	@Override
	public void deleteDept() {
		String id=new BsView().inputData("삭제할 부서아이디 ").toUpperCase();
		int result=service.deleteDept(id);
		new BsView().printMsg(result>0?"부서삭제성공":"부서삭제실패");
		
	}

	@Override
	public void insertJob() {
		Job j=new BsView().insertJob();
		int result=service.insertJob(j);
		new BsView().printMsg(result>0?"직책등록성공":"직책등록실패");
		
		
	}

	@Override
	public void updateJob() {
		String jc=new BsView().inputData("수정할 직책 ").toUpperCase();
		String jn=new BsView().updateJob();
		int result=service.updateJob(jc,jn);
		new BsView().printMsg(result>0?"직책수정성공":"직책수정실패");
	}

	@Override
	public void deleteJob() {
		String jc=new BsView().inputData("삭제할 직책 ").toUpperCase();
		int result=service.deleteJob(jc);
		new BsView().printMsg(result>0?"직책삭제성공":"직책삭제실패");
	}

	@Override
	public void jobMenu() {
		new BsView().jobMenu();
		
	}
	
	
}
