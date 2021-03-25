//package com.ltts.RestAPI.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ltts.RestAPI.Dao.userDao;
//import com.ltts.RestAPI.model.User;
//
//@RestController
//public class MainController {
//	@Autowired
//	private userDao ud;
//
//	@GetMapping(path = "/hello")
//	public String helloWorld() {
//		return "Hello World";
//	}
//	@GetMapping("/users")
//	public List<User> retriveAllUsers() {
//		return ud.findAll();
//	}
//
//	@GetMapping("/users/{id}")
//	public User retriveUser(@PathVariable int id) {
//		return ud.findOne(id);
//	}
//
//	@PostMapping("/adduser")
//	public void createUser(@RequestBody User user) {
//		User sevedUser = ud.save(user);
//	}
//	
//	@DeleteMapping("/deleteuser/{id}")  
//	public void deleteUser(@PathVariable int id) throws Exception  
//	{  
//	User user= ud.deleteById(id);  
//	if(user==null)  
//	//runtime exception  
//	throw new Exception("id: "+ id);  
//	} 
//}




package com.ltts.RestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltts.RestAPI.Dao.userDao;
import com.ltts.RestAPI.model.User;

@RestController
public class MainController {
	@Autowired
	private userDao ud;

	@GetMapping(path = "/hello")
	public String helloWorld() {
		return "Hello World";
	}
	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return ud.list();
	}

	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {
		return ud.getMemberByEmpId(id);
	}

	@PostMapping("/adduser")
	public void createUser(@RequestBody User user) {
		boolean savedUser = ud.InsertUser(user);
	}
	
	@PutMapping("/update/{id}")  
	public void updateUser(@PathVariable int id, @RequestBody String name) throws Exception  
	{  	
	boolean user= ud.updateUser(id, name);  
//	if(!user) 
//	throw new Exception("id: "+ id);  
	} 
}
