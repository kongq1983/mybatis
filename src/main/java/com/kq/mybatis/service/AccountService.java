package com.kq.mybatis.service;

import com.kq.mybatis.entity.Account;

import java.util.Map;

/**
 * TODO
 * @author kongqi
 * @date  2018-04-26 18:01 
 * @since 
 */
public interface AccountService {

	public String getName(String id);
	
	public void insert(Account a);

	public Map<String,Object> getAccountMap(Long id);
	
	public Account getAccount(Long id);

	public Account getAccount1(Account a);


	
}
