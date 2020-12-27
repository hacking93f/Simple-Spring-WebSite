package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.service.UserService;

@Controller
public class ControllerViewApp {

	HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		RestTemplate rt = new RestTemplate();
		return mav;
		
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		ModelAndView  mav= new ModelAndView();
		
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		

	session	 = request.getSession();
		
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dab", "user", "falsarone");
		PreparedStatement ps = conn.prepareStatement("select * from utenti where username=? and password=?");
		
		ps.setString(1, uname);
		ps.setString(2, pwd);


		ResultSet rs = ps.executeQuery();
		try {
			if(rs.next()) {
				

				session.setAttribute("username", uname);
				
				return new ModelAndView("redirect:/index");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}
			
		return new ModelAndView("redirect:/errore");
	}
	
	
	
	
	
	
	@RequestMapping(value="/index", method = RequestMethod.GET)
	public ModelAndView loginGet(HttpServletRequest request){
		
		ModelAndView  mav= new ModelAndView();
		HttpSession session = request.getSession();
		mav.setViewName("home");
		//Controller Logged Function
		try {
		String ok = session.getAttribute("we").toString();
		}catch(NullPointerException e) {	
			return new ModelAndView("redirect:/");
		}
		return mav;
	}
	
	
	
	
	
	
	
	
}

