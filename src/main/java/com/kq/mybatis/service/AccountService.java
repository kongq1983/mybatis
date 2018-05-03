package com.kq.mybatis.service;

import com.kq.mybatis.entity.Account;

/**
 * TODO
 * @author kongqi
 * @date  2018-04-26 18:01 
 * @since 
 */
public interface AccountService {

	public String getName(String id);
	
	public void insert(Account a);
	
	public Account getAccount(Long id);
	
}
