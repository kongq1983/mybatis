package com.kq.mybatis;

import java.io.IOException;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * TODO
 * 
 * @author kongqi
 * @date 2018-02-01 16:47
 * @since
 */

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.kq.mybatis" })
@MapperScan(basePackages = {"com.kq.mybatis.mapper"})  //mybatis扫描mapper
public class MybatisConfiguration {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	// @Bean
	// public PropertiesFactoryBean getPropertiesFactoryBean() {
	// PropertiesFactoryBean bean = new PropertiesFactoryBean();
	// Resource resource = new ClassPathResource("ctmessage.properties");
	// bean.setLocations(resource);
	// return bean;
	// }

	@Bean
	public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer bean = new PropertyPlaceholderConfigurer();
		Resource resource = new ClassPathResource("ctlogic.properties");
		bean.setLocations(resource);
		return bean;
	}

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl("jdbc:mysql://192.168.6.233:3306/test?useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		// if (properties.getInitialSize() > 0) {
		// dataSource.setInitialSize(properties.getInitialSize());
		// }
		// if (properties.getMinIdle() > 0) {
		// dataSource.setMinIdle(properties.getMinIdle());
		// }
		// if (properties.getMaxActive() > 0) {
		// dataSource.setMaxActive(properties.getMaxActive());
		// }
		// dataSource.setTestOnBorrow(properties.isTestOnBorrow());
		try {
			dataSource.init();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}

//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception {
//		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//		sessionFactory.setDataSource(dataSource());
//		return sessionFactory.getObject();
//	}

	/**
	 * mybatis集成
	 * 
	 * @return
	 */
	@Bean
	public SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(this.dataSource());

		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

		try {
			//加载mybatis配置文件
			bean.setMapperLocations(resolver.getResources("classpath*:mapper/**/*.xml"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			
			SqlSessionFactory obj = bean.getObject();
			obj.getConfiguration().getTypeHandlerRegistry().register(com.kq.mybatis.typehandler.LocationTypeHandler.class);
			
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
