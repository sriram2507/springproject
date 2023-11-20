package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.loginentity;
import com.example.demo.repository.loginrepository;

@RestController
public class logincontroller {
	@Autowired
	public loginrepository Repo;
	
	@PostMapping("/adddata")
	public loginentity addpro(@RequestBody loginentity pro) {
	try {
		Repo.save(pro);
		return pro;
	}catch(Exception e) {
		e.printStackTrace();
		
	}
	return null;
	}
	
	@GetMapping("/getdata")
	public List <loginentity> getdata(){
		try {
			return Repo.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	@PutMapping("/updatedata")
	public loginentity updatepro(@RequestBody loginentity pro) {
		try {
			Repo.save(pro);
			return pro;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	@DeleteMapping("/deletedata/{id}")
	public String delpro(@PathVariable int id) {
		try {
			loginentity pro = Repo.getOne(id);
			Repo.delete(pro);
			return "deleted";
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
