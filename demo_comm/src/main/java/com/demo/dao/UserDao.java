package com.demo.dao;

import org.springframework.stereotype.Repository;

import com.demo.common.mybatis.MyBatisDao;

@Repository
public class UserDao extends MyBatisDao {

	public UserDao() {
		super("USER");
	}

}