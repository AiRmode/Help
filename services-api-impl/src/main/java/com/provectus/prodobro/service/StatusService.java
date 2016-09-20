package com.provectus.prodobro.service;

import com.provectus.prodobro.dao.StatusDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class StatusService {


//	@Resource(name = "statusDAO")
//	private StatusDAO dao;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-services.xml");

		StatusDAO statusDAO = context.getBean("statusDAO", StatusDAO.class);

		try {
			statusDAO.pushStatusEnumToDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
}
