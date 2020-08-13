package com.yc.spring.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yc.spring.bank.Opercord;

//银行操作流水表的Dao

@Repository
public class OpercordDao {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	public int insert(int id,double money) {
		return jdbcTemplate.update("insert into oprecord values(null,?,?,null,now())",id,money);
	}
	
	public List<Opercord> selectById(int accountid){
		String sql="select * from oprecord where accountid=?";
		Object[] args= {accountid};
		return jdbcTemplate.query(sql,args, new RowMapper<Opercord>() {

			@Override
			public Opercord mapRow(ResultSet rs, int rowNum) throws SQLException {
				Opercord rc=new Opercord();
				rc.setId(rs.getInt("id"));
				rc.setAccountid(rs.getInt("accountid"));
				rc.setOpmoney(rs.getDouble("opmoney"));
				rc.setCharge(rs.getDouble("charge"));
				rc.setOptime(rs.getTimestamp("optime"));
				return rc;
			}
		});
	}
}
