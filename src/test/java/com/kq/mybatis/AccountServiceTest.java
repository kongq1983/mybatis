package com.kq.mybatis;

import com.kq.mybatis.entity.OrderBy;
import com.kq.mybatis.mapper.AccountMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kq.mybatis.entity.Account;
import com.kq.mybatis.service.AccountService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 * @author kongqi
 * @date  2018-03-29 16:56 
 * @since 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MybatisConfiguration.class })
public class AccountServiceTest {
	
	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountMapper accountMapper;
	
	
	@Test
	public void testGetUserName() {
//		VoNodeUser vo = userDao.getVoNodeUser("FF2A771A79234B1CB1D887F974F651CF");
//		System.out.println(vo);
//		List<VoNodeUser> voList = userDao.getVoNodeUsers(Lists.newArrayList("FF2A771A79234B1CB1D887F974F651CF"));
//		System.out.println(voList);
		
		String name = accountService.getName("C870046BBB8B4AE59C150AF0E383781B");
		
		System.out.println("name="+name);
	}
	
	@Test
	public void insert() {
		Account a = new Account();
		a.setAge(18);
		a.setName("king");
		a.setUsername("admin");
		
		accountService.insert(a);
		
		System.out.println("id="+a.getId());
	}
	
	@Test
	public void testGetUser() {
//		VoNodeUser vo = userDao.getVoNodeUser("FF2A771A79234B1CB1D887F974F651CF");
//		System.out.println(vo);
//		List<VoNodeUser> voList = userDao.getVoNodeUsers(Lists.newArrayList("FF2A771A79234B1CB1D887F974F651CF"));
//		System.out.println(voList);
		
		Account account = accountService.getAccount(1l);
		
		System.out.println("account="+account);
	}

	@Test
	public void testGetUserMap() {

		Map<String,Object> account = accountService.getAccountMap(1l);

		System.out.println("account="+account);
	}

	@Test
	public void testGetAccount1() {

		Account param = new Account();
		param.setId(1l);
		param.setUsername("admin");
		param.setName("king");
//		param.setUsername();
		Account account = accountService.getAccount1(param);

		System.out.println("account="+account);
	}

	@Test
	public void addTransaction(){
		Account param = new Account();
		param.setId(1l);
		param.setUsername("admin");
		param.setName("king");
		accountService.addTransaction(param);
	}


	@Test
	public void testList() {
//		VoNodeUser vo = userDao.getVoNodeUser("FF2A771A79234B1CB1D887F974F651CF");
//		System.out.println(vo);
//		List<VoNodeUser> voList = userDao.getVoNodeUsers(Lists.newArrayList("FF2A771A79234B1CB1D887F974F651CF"));
//		System.out.println(voList);

		OrderBy order1 = new OrderBy();
		order1.setOrderBy(-1);
		order1.setOrderByField("soldAmount");

		OrderBy order2 = new OrderBy();
		order2.setOrderBy(-11);
		order2.setOrderByField("price");

		List<OrderBy> list = new ArrayList<>();
		list.add(order1);
		list.add(order2);


		accountMapper.getAccountList(list);

	}

}
