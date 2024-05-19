package com.techpalle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.techpalle.model.Employee;

public class DataAccess {
	
	public void insert(Employee s ) 
	{
		//write the JDBC code for inserting data into DB
		Connection c=null;
		PreparedStatement p=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
		    p = c.prepareStatement("insert into Employee(sname,email,dept,status) values(?,?,?,?)");
			p.setString(1,s.getName());
			p.setString(2, s.getEmail());
			p.setString(3,s.getDepartment());
			p.setString(4,s.getStatus());
			p.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(p!=null)
			{
				try {
					p.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public ArrayList<Employee> getAllEmployee()
	{
		ArrayList<Employee> a=new ArrayList<Employee>();
		Connection c=null;
		Statement s=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
		    s = c.createStatement();
		    ResultSet r = s.executeQuery("select * from Employee");
		    while(r.next())
		    {
		    	int i = r.getInt("sno");
		    	String n = r.getString("sname");
		    	String e = r.getString("email");
		    	String d = r.getString("dept");
		    	String a = r.getString("status");
		    	Employee emp=new Employee(i, n, e, d, a);
		    	a.add(emp);
		    }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return a;
		
	}
	public void update(Employee s)
	{
		Connection c=null;
		PreparedStatement p=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
		    p = c.prepareStatement("update Employee set sname=?,email=?,dept=?,status=? where sno=?");
		   
			p.setString(1,s.getName());
			p.setString(2, s.getEmail());
			p.setString(3,s.getDepartment());
			p.setString(4,s.getStatus());
			p.setInt(5, s.getId());
			
			p.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(p!=null)
			{
				try {
					p.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public Employee getEmployeeById(int id)
	{
		Employee s=new Employee();
		
		Connection c=null;
		PreparedStatement p=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","admin");
			p=c.prepareStatement("select * from Employee where sno=?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();
			if(r.next())
			{
				s.setId(id);
				s.setName(r.getString("sname"));
				s.setEmail(r.getString("email"));
				s.setDepartment(r.getString("dept"));
				s.setStatus(r.getString("status"));
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(p!=null)
			{
				try {
					p.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return s;
		
	}
	public void delete(int id)
	{
		Connection c=null;
		PreparedStatement p=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring", "root", "admin");
		    p = c.prepareStatement("delete from Employee where sno=?");
			p.setInt(1, id);
			p.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(p!=null)
			{
				try {
					p.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
