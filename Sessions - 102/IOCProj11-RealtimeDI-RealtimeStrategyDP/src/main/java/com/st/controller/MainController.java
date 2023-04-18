package com.st.controller;

import com.st.dto.EmployeeDTO;
import com.st.service.IEmployeeMgmtService;
import com.st.vo.EmployeeVO;

public class MainController {
	//HAS -A property
	private IEmployeeMgmtService service;

	// alt+shift+s, o
	public MainController(IEmployeeMgmtService service) {
		System.out.println("MainController.1-param constructor");
		this.service = service;
	}
	
	public String   processEmployee(EmployeeVO vo)throws Exception{
		//convert EmployeeVO class object to EmployeDTO class obj
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEname(vo.getEname());
		dto.setDesg(vo.getDesg());
		dto.setBasicSalary(Float.parseFloat(vo.getBasicSalary()));
		//use service
		String result=service.registerEmployee(dto);
		
		return result;
	}
	
	
	
	

}
