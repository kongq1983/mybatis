package com.kq.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kq.mybatis.service.AccountService;

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
	
	
	@Test
	public void testGetUser() {
//		VoNodeUser vo = userDao.getVoNodeUser("FF2A771A79234B1CB1D887F974F651CF");
//		System.out.println(vo);
//		List<VoNodeUser> voList = userDao.getVoNodeUsers(Lists.newArrayList("FF2A771A79234B1CB1D887F974F651CF"));
//		System.out.println(voList);
		
		String name = accountService.getName("C870046BBB8B4AE59C150AF0E383781B");
		
		System.out.println("name="+name);
	}
	
}
