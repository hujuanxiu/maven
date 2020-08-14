package com.yc.spring.bank.biz;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.spring.bank.dao.AccountDao;
import com.yc.spring.bank.dao.OpercordDao;

/**
 * 银行业务类
 * 开户:向account表添加一条记录《新增）
 * 存取款:修改accont的余额（修改），记录流水表（只是新增）
 *       卡号 密码  余额
 * 转账:A账户减少，B账户增加
 * 查询:根据卡号查余额
 * 
 */
@Service
@Transactional(rollbackFor = {IOException.class ,SQLException.class})
public class BankBiz {

	@Resource
	private AccountDao aDao;
	@Resource
	private OpercordDao oDao;
	
	//开户
	public void register(int id,String pwd,double money) {
		/**
		 * jdbcTemplate每个update都有独立的事务控制
		 * try{
		 *    业务代码
		 *    提交操作
		 * }catch(Exception e){
		 *    回滚操作
		 * }finally{
		 *    关闭连接
		 */
		//省略参数校验
		aDao.insert(id, pwd, money);
		oDao.insert(id, money);
	}
	
	//存取款
	 @Transactional(rollbackFor = {BizException.class}) 
	public void save(int id,double money) throws BizException {
		//省略参数校验
		aDao.update(id, money);
		/* try { */
		    if(money > 999) {
			   throw new BizException("存取款金额不能大于999");
		    }
		/*}catch (BizException e) {
			//将该编译期异常转化为运行期异常
			throw new DataAccessResourceFailureException("异常转型",e);
		}*/
		oDao.insert(id, money);
	}
	
	public void transfer(int id1,int id2,double money) throws BizException {
		save(id1, -money);
		save(id2, money);
	}
}
