package com.kq.mybatis.service.impl;

import com.kq.mybatis.entity.Account;
import com.kq.mybatis.mapper.AccountMapper;
import com.kq.mybatis.service.AccountService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * TODO
 * @author kongqi
 * @date  2018-04-26 18:02 
 * @since 
 */
@Service
public class AccountServiceImpl implements AccountService ,ApplicationContextAware {
	
	@Autowired
	private AccountMapper accountMapper;

	private AccountService accountService;

	ApplicationContext applicationContext;

	@PostConstruct
	public void init(){
		System.out.println("accountService init");
		this.accountService = applicationContext.getBean(AccountService.class);
	}

	@Override
	public String getName(String id) {
		System.out.println("id="+id);
		return accountMapper.getName(id);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void insert(Account a) {
		accountMapper.insert(a);
	}
	
	public Account getAccount(Long id) {
		return this.accountMapper.getAccount(id);
	}

	public Map<String,Object> getAccountMap(Long id) {
		return this.accountMapper.getAccountMap(id);
	}

	public Account getAccount1(Account a) {
		return this.accountMapper.getAccount1(a);
	}


	@Transactional
	public void addTransaction(Account a) {
		Account aa = new Account();
		aa.setUsername("wang");
		aa.setAge(20);
		aa.setName("hello");
		System.out.println("this="+this);
//		this.insert(aa);
		System.out.println("accountService = "+accountService);
		this.accountService.insert(aa);
		a.setUsername("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
		this.accountMapper.insert(a);

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("accountService setApplicationContext");
		this.applicationContext = applicationContext;
	}
}
