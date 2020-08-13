package com.yc.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.Account;

//银行账号Dao
@Repository
public class AccountDao {

	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	//开户
	public int insert(int id,String pwd,double money) {
		return jdbcTemplate.update("insert into account values(?,?,?)",id,pwd,money);
	}
	
	public int update(int id,double money) {
		return jdbcTemplate.update("update account set balance= balance+? where accountid=?",money,id);
	}
	
	public Account selectById(int id) {
		String sql="select * from account where accountid=?";
		Object [] args= {id};
		return jdbcTemplate.query(sql, args,new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				Account ac=new Account();
				ac.setAccountid(rs.getInt("accountid"));
				ac.setPassword(rs.getString("password"));
				ac.setBalance(rs.getDouble("balance"));
				return ac;
			}
		});
	}
	
}
