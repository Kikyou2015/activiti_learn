package com.zcw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zcw.dao.UserDao;
import com.zcw.entitiy.User;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable String id) {
		return userDao.findById(new Long(id));
	}
}
