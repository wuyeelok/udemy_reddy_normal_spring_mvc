package com.kenneth.springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kenneth.springmvc.dao.AlienDao;
import com.kenneth.springmvc.model.Alien;
import com.kenneth.springmvc.model.ReddyAlien;

@Controller
public class HomeController {

	private final AlienDao dao;

	@Autowired
	public HomeController(@Qualifier("reddyADao") AlienDao dao) {
		this.dao = dao;
	}

	@ModelAttribute
	public void modelData(Model m) {
		System.out.println("calling model data method");
		m.addAttribute("name", "XXXX");
	}

	@GetMapping("/")
	public String home() {
		System.out.println("calling home method");

		// Test JDBC
		Connection myConn = null;
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/kenneth_alien?useSSL=false&serverTimezone=UTC";

			String user = "kenken";

			String pass = "12345678";

			System.out.println("Connect to database: " + jdbcUrl + "...");

			myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful!!!");

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myConn != null) {
				try {
					myConn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return "index";
	}

	@PostMapping("add")
	public String add(@RequestParam("num1") int i, @RequestParam("num2") int j, Model m) {

		int num3 = i + j;
		m.addAttribute("num3", num3);

		return "result";
	}

	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("a1") ReddyAlien a, ModelMap map) {
		System.out.println("calling addAlien method");

		this.dao.add(a);

		map.clear();

		return "redirect:getAliens";
	}

	@GetMapping("getAliens")
	public String getAliens(Model m) {

		List<Alien> aliens = this.dao.getAliens();

		m.addAttribute("result", aliens);

		return "showAliens";
	}
}
