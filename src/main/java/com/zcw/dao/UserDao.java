package com.zcw.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.zcw.entitiy.User;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findById(Long id);
}
