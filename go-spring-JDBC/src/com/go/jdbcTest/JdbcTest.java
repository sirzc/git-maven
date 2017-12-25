package com.go.jdbcTest;

import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

import com.go.jdbc.BeanUntil;
import com.go.jdbc.Customer;

/**   
 * @Title: JdbcTest.java
 * @Package com.go.jdbcTest
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：zc
 * @date 创建时间：2017年10月23日 下午3:45:24
 * @version V1.0   
 */
public class JdbcTest {

	@Test
	public void jabcTest() {
		JdbcTemplate jdbcTemplate = (JdbcTemplate) BeanUntil.getBean("jdbcTemplate");
		String sql="select * from customer";
		RowMapper<Customer> rowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Customer.class);
		List<Customer> list = jdbcTemplate.query(sql, rowMapper);
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
}
