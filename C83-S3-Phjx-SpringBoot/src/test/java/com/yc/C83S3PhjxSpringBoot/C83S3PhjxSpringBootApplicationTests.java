package com.yc.C83S3PhjxSpringBoot;

import javax.annotation.Resource;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailSender;
import org.springframework.util.Assert;

import com.yc.C83S3PhjxSpringBoot.biz.MailService;
import com.yc.C83S3PhjxSpringBoot.dao.ProductMapper;

@SpringBootTest
class C83S3PhjxSpringBootApplicationTests {

	@Resource
	ProductMapper pm;
	@Resource
	MailService ms;
	
	@Test
	void contextLoads() {
		Assert.isTrue(pm.selectAll().size()>0, "没有数据");
	}
	
	@Test
	void textMail() {
		ms.sendSimpleMail("1050576172@qq.com", "有人正在登录你的账号!请及时修改密码", "请与好友验证，若不是，请忽略此消息");
	}

}
