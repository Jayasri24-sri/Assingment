package com.techpalle.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Employee;

@Controller
public class StudentController {
	@RequestMapping(value="CRUD",params="Register")
	public ModelAndView goToRegisterPage()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("register.jsp");
		return mv;
		
	}
	@RequestMapping("reg")
	public ModelAndView insertEmployee(HttpServletRequest request)
	{
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String d = request.getParameter("tbdept");
		String a = request.getparameter("tbstatus");
		
		Employee s=new Employee(n,e,d,a);
		DataAccess d=new DataAccess();
		d.insert(s);
		ModelAndView mv=new ModelAndView();
		mv.addObject("res","inserted");
		mv.setViewName("register.jsp");
		return mv;
		
		
	}
	@RequestMapping(value="CRUD" ,params="Show")
	public ModelAndView showAllEmployee()
	{
		ModelAndView mv=new ModelAndView();
		DataAccess d=new DataAccess();
		ArrayList<Student> a = d.getAllEmployee();
		mv.addObject("obj", a);
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	@RequestMapping("edit")
	public ModelAndView displayEditForm(int id)
	{
		ModelAndView mv=new ModelAndView();
		//step1: retrieve the old data from DB
		DataAccess d=new DataAccess();
		Student stu = d.getEmployeeById(id);
		mv.addObject("Employee", emp);
		//step2: redirect user to edit form[register.jsp]
		//to display the old data in controls
		mv.setViewName("register.jsp");
		return mv;
		
	}
	@RequestMapping("update")
	public ModelAndView updateEmployee(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		//step1: read the data from register.jsp page
		int i= Integer.parseInt(request.getParameter("tbid"));
		String n = request.getParameter("tbName");
		String e = request.getParameter("tbEmail");
		String d = request.getParameter("tbdept");
		String a = request.getParameter("tbstatus");
		
		Student s=new Student(i, n, e, d, a);
		//step2: update the value in DB
		DataAccess d=new DataAccess();
		d.update(s);
		
		//step3: redirect user to display.jsp with updated value
		ArrayList<Student> a = d.getAllEmployee();
		mv.addObject("obj", a);
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	@RequestMapping("delete")
	public ModelAndView deleteEmployee(int id)
	{
		ModelAndView mv=new ModelAndView();
		//step1: call the delete method present in DataAccess layer
		DataAccess d=new DataAccess();
		d.delete(id);
		//step2: redirect user to display page with remaining row leftout in table
		ArrayList<Employee> a = d.getAllEmployee();
		mv.addObject("obj", a);
		mv.setViewName("display.jsp");
		
		return mv;
		
	}
	
}
