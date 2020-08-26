package com.yc.C83S3Phjxblog.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.C83S3Phjxblog.bean.Comment;
import com.yc.C83S3Phjxblog.dao.CommentMapper;

@Service
public class CommentBiz {
	
	@Resource
	private CommentMapper cMapper;
	
	public Comment create(Comment comm) {
		cMapper.insert(comm);
		return comm;
	}

}
