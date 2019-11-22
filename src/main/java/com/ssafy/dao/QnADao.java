package com.ssafy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vo.PageBean;
import com.ssafy.vo.Comment;
import com.ssafy.vo.QnA;

@Mapper
public interface QnADao {
	public int  getQno(int qno);
	public void insert(QnA board);
	public void insertComment(Comment com);
	public QnA search(int no);
	public List<QnA> searchAll();
	public void update(QnA board);
	public void delete(int no) ;
	public void deleteComment(int cno);
	public List<Comment> searchComments(int qno);
}













