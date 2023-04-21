package com.jdbc.service;

import java.sql.Connection;
import java.util.List;
import static com.jdbc.common.JDBCTemplate.*;

import com.jdbc.model.dao.BsDao;
import com.jdbc.model.dto.Department;
import com.jdbc.model.dto.Employee;
import com.jdbc.model.dto.Job;

public class BsService {
	BsDao bd=new BsDao();
	public List<Employee> selectEmpAll(){
		Connection conn=getConnection();
		List<Employee> emp=bd.selectEmpAll(conn);
		close(conn);
		return emp;
	}
	
	public List<Employee> selectEmpDept(String dept){
		Connection conn=getConnection();
		List<Employee> emp=bd.selectEmpDept(conn,dept);
		close(conn);
		return emp;
	}
	
	public List<Employee> selectEmpJob(String job){
		Connection conn=getConnection();
		List<Employee> emp=bd.selectEmpJob(conn,job);
		close(conn);
		return emp;
	}
	
	public List<Employee> selectEmpName(String name){
		Connection conn=getConnection();
		List<Employee> emp=bd.selectEmpName(conn,name);
		close(conn);
		return emp;
	}
	
	public List<Employee> selectEmpSalaryOver(int sal){
		Connection conn=getConnection();
		List<Employee> emp=bd.selectEmpSalaryOver(conn,sal);
		close(conn);
		return emp;
	}
	
	public List<Employee> selectEmpSalaryUnder(int sal){
		Connection conn=getConnection();
		List<Employee> emp=bd.selectEmpSalaryUnder(conn,sal);
		close(conn);
		return emp;
	}
	
	public int insertEmp(Employee e) {
		Connection conn=getConnection();
		int result=bd.insertEmp(conn, e);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int updateEmp(String id, Employee e) {
		Connection conn=getConnection();
		int result=bd.updateEmp(conn, id, e);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int deleteEmp(String id) {
		Connection conn=getConnection();
		int result=bd.deleteEmp(conn, id);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int insertDept(Department d) {
		Connection conn=getConnection();
		int result=bd.insertDept(conn, d);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int updateDept(String id, Department d) {
		Connection conn=getConnection();
		int result=bd.updateDept(conn,id,d);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int deleteDept(String id) {
		Connection conn=getConnection();
		int result=bd.deleteDept(conn, id);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int insertJob(Job j) {
		Connection conn=getConnection();
		int result=bd.insertJob(conn, j);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int updateJob(String jc, String jn) {
		Connection conn=getConnection();
		int result=bd.updateJob(conn,jc,jn);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	
	public int deleteJob(String jc) {
		Connection conn=getConnection();
		int result=bd.deleteJob(conn, jc);
		if(result>0) commit(conn);
		else rollBack(conn);
		close(conn);
		return result;
	}
	

}















