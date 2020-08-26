package com.yc.C83S3Phjxblog.web;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.github.pagehelper.PageHelper;
import com.yc.C83S3Phjxblog.bean.Comment;
import com.yc.C83S3Phjxblog.bean.Result;
import com.yc.C83S3Phjxblog.bean.User;
import com.yc.C83S3Phjxblog.biz.CommentBiz;
import com.yc.C83S3Phjxblog.dao.CommentMapper;

@RestController
public class CommentAction {
	
	@Resource
	private CommentMapper cMapper;
	
	@Resource
	private CommentBiz cbiz;
	
	@PostMapping("comment")
	public Result comment(Comment comm, @SessionAttribute User loginedUser) {
		comm.setCreateby(loginedUser.getId());
		cbiz.create(comm);
		return new Result(1,"回复成功",comm);
	}
	
	@GetMapping("queryComm")
	public Result comment(int articleid,Model model) {
		return new Result(1, "显示全部评论", cMapper.selectByArticle(articleid));
	}
	
	

}
