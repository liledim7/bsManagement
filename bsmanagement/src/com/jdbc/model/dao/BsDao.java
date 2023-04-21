package com.jdbc.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.jdbc.common.JDBCTemplate.*;

import com.jdbc.model.dto.Employee;

public class BsDao {
	Properties sql=new Properties();
	{
		try {
			String path=BsDao.class.getResource("/sql/employee/employeebs_sql.properties").getPath();
		sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public List<Employee> selectEmpAll(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectEmpAll");
		List<Employee> emp=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				emp.add(getEmp(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return emp;
	}
	
	public List<Employee> selectEmpDept(Connection conn, String dept){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectEmpDept");
		List<Employee> emp=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dept);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				emp.add(getEmp(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return emp;
	}
	
	public List<Employee> selectEmpJob(Connection conn, String job){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectEmpJob");
		List<Employee> emp=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, job);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				emp.add(getEmp(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return emp;
	}
	
	public List<Employee> selectEmpName(Connection conn, String name){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectEmpName");
		List<Employee> emp=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				emp.add(getEmp(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return emp;
	}
	
	public List<Employee> selectEmpSalaryOver(Connection conn, int sal){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectEmpSalaryOver");
		List<Employee> emp=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sal);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				emp.add(getEmp(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return emp;
		
	}
	
	public List<Employee> selectEmpSalaryUnder(Connection conn, int sal){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=this.sql.getProperty("selectEmpSalaryUnder");
		List<Employee> emp=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, sal);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				emp.add(getEmp(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return emp;
		
	}
	
	public int insertEmp(Connection conn, Employee e) {
		PreparedStatement pstmt=null;
		String sql=this.sql.getProperty("insertEmp");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, e.getEmpId());
			pstmt.setString(2, e.getEmpName());
			pstmt.setString(3, e.getEmpNo());
			pstmt.setString(4, e.getEmail());
			pstmt.setString(5, e.getPhone());
			pstmt.setString(6, e.getDeptCode());
			pstmt.setString(7, e.getJobCode());
			pstmt.setString(8, e.getSalLevel());
			pstmt.setInt(9, e.getSalary());
			pstmt.setDouble(10, e.getBonus());
			pstmt.setString(11, e.getManagerId());
			pstmt.setDate(12, e.getHireDate());
			pstmt.setString(13, e.getEntYn().toUpperCase());
			result=pstmt.executeUpdate();
		}catch(SQLException ee) {
			ee.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int updateEmp(Connection conn, String id,Employee e) {
		PreparedStatement pstmt=null;
		String sql=this.sql.getProperty("updateEmp");
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, e.getJobCode());
			pstmt.setString(2, e.getDeptCode());
			pstmt.setInt(3, e.getSalary());
			pstmt.setString(4, e.getPhone());
			pstmt.setString(5, e.getEmail());
			pstmt.setString(6, id);
			result=pstmt.executeUpdate();
		}catch(SQLException ee) {
			ee.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	private Employee getEmp(ResultSet rs) throws SQLException {
		Employee e=new Employee();
		e.setEmpId(rs.getString("emp_id"));
		e.setEmpName(rs.getString("emp_name"));
		e.setEmpNo(rs.getString("emp_no"));
		e.setEmail(rs.getString("email"));
		e.setPhone(rs.getString("phone"));
		e.setDeptCode(rs.getString("dept_code"));
		e.setJobCode(rs.getString("job_code"));
		e.setSalLevel(rs.getString("sal_level"));
		e.setSalary(rs.getInt("salary"));
		e.setBonus(rs.getDouble("bonus"));
		e.setManagerId(rs.getString("manager_id"));
		e.setHireDate(rs.getDate("hire_date"));
		e.setEntDate(rs.getDate("ent_date"));
		e.setEntYn(rs.getString("ent_yn"));
		return e;
		
	}
}












