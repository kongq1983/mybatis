package com.kq.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kq.mybatis.entity.Account;
import com.kq.mybatis.mapper.AccountMapper;
import com.kq.mybatis.service.AccountService;

/**
 * TODO
 * @author kongqi
 * @date  2018-04-26 18:02 
 * @since 
 */
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountMapper accountMapper;

	@Override
	public String getName(String id) {
		System.out.println("id="+id);
		return accountMapper.getName(id);
	}
	
	public void insert(Account a) {
		accountMapper.insert(a);
	}
	
	public Account getAccount(Long id) {
		return this.accountMapper.getAccount(id);
	}

}
