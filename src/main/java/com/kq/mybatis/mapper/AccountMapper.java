package com.kq.mybatis.mapper;

import com.kq.mybatis.entity.Account;

/**
 * TODO
 * @author kongqi
 * @date  2018-04-26 18:00 
 * @since 
 */
public interface AccountMapper {
	
	public String getName(String id);
	
	
	public void insert(Account a);
	
	public Account getAccount(Long id);

	public Map<String,Object> getAccountMap(Long id);

	public Account getAccount1(Account a);

}
