package com.demo.back.dao;

import org.springframework.stereotype.Repository;

import com.demo.back.common.mybatis.MyBatisDao;

@Repository
public class UserDao extends MyBatisDao {

	public UserDao() {
		super("USER");
	}

}